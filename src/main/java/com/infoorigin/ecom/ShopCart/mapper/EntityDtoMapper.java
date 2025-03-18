package com.infoorigin.ecom.ShopCart.mapper;


import com.infoorigin.ecom.ShopCart.dtos.AddressDto;
import com.infoorigin.ecom.ShopCart.dtos.CategoryDto;
import com.infoorigin.ecom.ShopCart.dtos.OrderItemDto;
import com.infoorigin.ecom.ShopCart.dtos.UserDto;
import com.infoorigin.ecom.ShopCart.entities.Address;
import com.infoorigin.ecom.ShopCart.entities.Category;
import com.infoorigin.ecom.ShopCart.entities.OrderItem;
import com.infoorigin.ecom.ShopCart.entities.User;
import org.springframework.stereotype.Component;

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

    //Address to AddressDto
    public AddressDto mapAddressToDtoBasic(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setCountry(address.getCountry());
        addressDto.setState(address.getState());
        addressDto.setCity(address.getCity());
        addressDto.setZipCode(address.getZipCode());
        return addressDto;
    }

    //Category to CategoryDto
    public CategoryDto mapAddressToDtoBasic(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());

        return categoryDto;
    }

    //OrderItem to OrderItemDto
    public OrderItemDto mapOrderItemToDtoBasic(OrderItem orderItem) {
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(orderItem.getId());
        orderItemDto.setPrice(orderItem.getPrice());
        orderItemDto.setQuantity(orderItem.getQuantity());
        orderItem.setStatus(orderItem.getStatus());
        orderItemDto.setCreatedAt(orderItem.getCreatedAt());

        return orderItemDto;
    }
}
