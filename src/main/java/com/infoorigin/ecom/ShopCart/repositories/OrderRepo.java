package com.infoorigin.ecom.ShopCart.repositories;

import com.infoorigin.ecom.ShopCart.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order , Long> {
}
