package com.example.twornet.repositories;

import com.example.twornet.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);
    List<Product> findByCity(String city);
    List<Product> findByTitleAndCity(String title, String city);
    List<Product> findByTitleAndCityAndClassification(String title, String city, String classification);
    List<Product> findByTitleAndClassification(String title, String classification);
    List<Product> findByCityAndClassification(String city, String classification);
    List<Product> findByClassification(String classification);

    List<Product> findByUserId(long id);
}
