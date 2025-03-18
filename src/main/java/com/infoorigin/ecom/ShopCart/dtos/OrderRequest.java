package com.infoorigin.ecom.ShopCart.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.infoorigin.ecom.ShopCart.entities.Payment;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequest {
    private BigDecimal totalPrice;
    private List<OrderItemRequest> items;
    private Payment paymentInfo;
}
