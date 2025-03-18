package com.infoorigin.ecom.ShopCart.dtos;

import lombok.Data;

@Data
public class OrderItemRequest {
    private int productId;
    private int quantity;
}
