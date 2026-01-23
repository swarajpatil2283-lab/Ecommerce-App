package com.ecommerce.repository;

import java.util.Optional;

import com.ecommerce.model.Cart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
    static Cart findByUserId(Long userId);
}