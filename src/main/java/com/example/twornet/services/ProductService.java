package com.example.twornet.services;

import com.example.twornet.models.*;
import com.example.twornet.repositories.CitiesRepository;
import com.example.twornet.repositories.InformUserRepository;
import com.example.twornet.repositories.ProductRepository;
import com.example.twornet.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CitiesRepository citiesRepository;
    private final InformUserRepository informUserRepository;

    public List<Cities> citiesList() {
        return citiesRepository.findAll();
    }

    public List<Product> listProducts(String title, String city, String classification, String umor, String marshrut,
                                      String punktualnost, String opryatnost, String mestnost, String beseda) {

        if (title == null && city == null && classification == null) {
            return productRepository.findAll();
        }

        if (title != "" && city != "" && classification != "") {
            return productRepository.findByTitleAndCityAndClassification(title, city, classification);
        }

        if (title != "" && city != "") {
            return productRepository.findByTitleAndCity(title, city);
        }
        if (title != "" && classification != "") {
            return productRepository.findByTitleAndClassification(title, classification);
        }
        if (classification != "" && city != "") {
            return productRepository.findByCityAndClassification(city, classification);
        }

        if (city != "" && city != null) {
            return productRepository.findByCity(city);
        }
        if (title != "") {
            return productRepository.findByTitle(title);
        }
        if (classification != "") {
            return productRepository.findByClassification(classification);
        }
        if (umor != null) {
            InformUser informUser=informUserRepository.findInformUserByUmorGreaterThan(0.5);
            return productRepository.findByUserId(informUser.getUser().getId());
        }
        if (marshrut != null) {
            InformUser informUser=informUserRepository.findInformUserByMarshrutGreaterThan(0.5);
            return productRepository.findByUserId(informUser.getUser().getId());
        }
        if (punktualnost != null) {
            InformUser informUser=informUserRepository.findInformUserByPunktualnostGreaterThan(0.5);
            return productRepository.findByUserId(informUser.getUser().getId());
        }
        if (opryatnost != null) {
            InformUser informUser=informUserRepository.findInformUserByOpryatnostGreaterThan(0.5);
            return productRepository.findByUserId(informUser.getUser().getId());
        }
        if (mestnost != null) {
            InformUser informUser=informUserRepository.findInformUserByMestnostGreaterThan(0.5);
            return productRepository.findByUserId(informUser.getUser().getId());
        }
        if (beseda != null) {
            InformUser informUser=informUserRepository.findInformUserByBesedaGreaterThan(0.5);
            return productRepository.findByUserId(informUser.getUser().getId());
        }
        return productRepository.findAll();

    }//Search

    public void saveProduct(Principal principal, Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        product.setUser(getUserByPrincipal(principal));
        Image image1;
        Image image2;
        Image image3;

        image1 = toImageEntity(file1);
        image1.setPreviewImage(true);
        product.addImageToProduct(image1);

        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            product.addImageToProduct(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            product.addImageToProduct(image3);
        }

        log.info("Saving new Product. Title: {}; Author email: {}", product.getTitle(), product.getUser().getEmail());

        Product productFromDb = productRepository.save(product);
        productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
        productRepository.save(product);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}