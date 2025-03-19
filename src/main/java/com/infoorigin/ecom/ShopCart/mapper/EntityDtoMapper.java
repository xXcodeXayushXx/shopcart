package com.infoorigin.ecom.ShopCart.mapper;

import com.infoorigin.ecom.ShopCart.dtos.*;
import com.infoorigin.ecom.ShopCart.entities.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EntityDtoMapper {
    // User to UserDto
    public UserDto mapUserToDtoBasic(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setRole(user.getRole().name());
        userDto.setUsername(user.getUsername());
        return userDto;
    }

    // Address to AddressDto
    public AddressDto mapAddressToDtoBasic(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setCountry(address.getCountry());
        addressDto.setState(address.getState());
        addressDto.setCity(address.getCity());
        addressDto.setZipCode(address.getZipCode());
        return addressDto;
    }

    // Category to CategoryDto
    public CategoryDto mapCategoryToDtoBasic(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

    // OrderItem to OrderItemDto
    public OrderItemDto mapOrderItemToDtoBasic(OrderItem orderItem) {
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(orderItem.getId());
        orderItemDto.setPrice(orderItem.getPrice());
        orderItemDto.setQuantity(orderItem.getQuantity());
        orderItemDto.setStatus(orderItem.getStatus().name());
        orderItemDto.setCreatedAt(orderItem.getCreatedAt());
        return orderItemDto;
    }

    public ProductDto mapProductToDtoBasic(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setPrice(product.getPrice());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setImgUrl(product.getImgUrl());
        return productDto;
    }

    // User to UserDto + Address
    public UserDto mapUserToDtoPlusAddress(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDto = mapUserToDtoBasic(user);
        if (user.getAddress() != null) {
            userDto.setAddress(mapAddressToDtoBasic(user.getAddress()));
        }
        return userDto;
    }

    // OrderItem to OrderItemDto + Product
    public OrderItemDto mapOrderItemToDtoPlusProduct(OrderItem orderItem) {
        if (orderItem == null) {
            return null;
        }
        OrderItemDto orderItemDto = mapOrderItemToDtoBasic(orderItem);
        if (orderItem.getProduct() != null) {
            orderItemDto.setProduct(mapProductToDtoBasic(orderItem.getProduct()));
        }
        return orderItemDto;
    }

    // OrderItem to OrderItemDTO + User + Product
    public OrderItemDto mapOrderItemDtoPlusUserAndProduct(OrderItem orderItem) {
        if (orderItem == null) {
            return null;
        }
        OrderItemDto orderItemDto = mapOrderItemToDtoPlusProduct(orderItem);
        if (orderItem.getUser() != null) {
            orderItemDto.setUser(mapUserToDtoBasic(orderItem.getUser()));
        }
        return orderItemDto;
    }

    // User to UserDto + Address + Order Items History
    public UserDto mapUsertoDtoPlusAddressAndOrderHistory(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDto = mapUserToDtoPlusAddress(user);
        if (user.getItems() != null && !user.getItems().isEmpty()) {
            userDto.setItems(user.getItems()
                    .stream()
                    .map(this::mapOrderItemToDtoPlusProduct)
                    .collect(Collectors.toList()));
        }
        return userDto;
    }
}
