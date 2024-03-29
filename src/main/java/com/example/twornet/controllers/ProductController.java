package com.example.twornet.controllers;

import com.example.twornet.models.Product;
import com.example.twornet.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false) String title,
                           @RequestParam(name = "city", required = false) String city,
                           @RequestParam(name = "classification", required = false) String classification,
                           @RequestParam(name = "umor", required = false) String umor,
                           @RequestParam(name = "marshrut", required = false) String marshrut,
                           @RequestParam(name = "punktualnost", required = false) String punktualnost,
                           @RequestParam(name = "opryatnost", required = false) String opryatnost,
                           @RequestParam(name = "mestnost", required = false) String mestnost,
                           @RequestParam(name = "beseda", required = false) String beseda,
                           Principal principal, Model model) {
        model.addAttribute("products", productService.listProducts(title, city, classification, umor, marshrut, punktualnost, opryatnost, mestnost, beseda));
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        model.addAttribute("cities", productService.citiesList());
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("images", product.getImages());
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3, Product product, Principal principal) throws IOException {
        productService.saveProduct(principal, product, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/lk";
    }

    @GetMapping("/neweks")
    public String newEks(Model model) {
        model.addAttribute("cities", productService.citiesList());
        return "neweks";
    }
}
