package com.infoorigin.ecom.ShopCart.repositories;

import com.infoorigin.ecom.ShopCart.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findBy(String email);
}
