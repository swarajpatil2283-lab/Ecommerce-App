package com.ecommerce.dto;

import com.ecommerce.domain.OrderStatus;
import com.ecommerce.domain.PaymentStatus;
import com.ecommerce.model.Address;
import com.ecommerce.model.OrderItem;
import com.ecommerce.model.PaymentDetails;
import com.ecommerce.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

    @Data
    public class OrderDto {

        private Long id;



        private String OrderId;

        private UserDto user;

        private Long sellerId;

        private List<OrderItemDto> orderItems = new ArrayList<>();

        private Address shippingAddress;

        private PaymentDetails paymentDetails=new PaymentDetails();

        private double totalMrpPrice;

        private Integer totalSellingPrice;

        private Integer discount;

        private int totalItem;

        private PaymentStatus paymentStatus=PaymentStatus.PENDING;

        private LocalDateTime orderDate = LocalDateTime.now();
        private LocalDateTime deliverDate = orderDate.plusDays(7);


    }

}
