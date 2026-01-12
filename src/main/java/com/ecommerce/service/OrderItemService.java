package com.ecommerce.service;
import com.ecommerce.exception.OrderException;
import com.ecommerce.model.OrderItem;
import com.ecommerce.model.Product;

public interface OrderItemService {
    OrderItem getOrderItemById(Long id) throws Exception;
}
