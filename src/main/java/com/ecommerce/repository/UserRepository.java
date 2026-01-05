package com.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import com.ecommerce.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByEmail(String username);
}