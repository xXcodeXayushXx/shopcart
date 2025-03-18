package com.infoorigin.ecom.ShopCart.repositories;

import com.infoorigin.ecom.ShopCart.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);
    List<Product> findByNameOrDescriptionContaining(String name, String description);
}
