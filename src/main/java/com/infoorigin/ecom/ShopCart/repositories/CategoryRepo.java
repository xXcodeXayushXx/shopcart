package com.infoorigin.ecom.ShopCart.repositories;


import com.infoorigin.ecom.ShopCart.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CategoryRepo extends JpaRepository<Category, Long> {

}
