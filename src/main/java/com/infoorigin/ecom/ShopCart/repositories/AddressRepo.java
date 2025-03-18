package com.infoorigin.ecom.ShopCart.repositories;

import com.infoorigin.ecom.ShopCart.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
