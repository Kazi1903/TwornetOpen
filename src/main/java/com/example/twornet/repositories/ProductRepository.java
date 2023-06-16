package com.example.twornet.repositories;

import com.example.twornet.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);
    List<Product> findByCity(String city);
    List<Product> findByTitleAndCity(String title, String city);
}
