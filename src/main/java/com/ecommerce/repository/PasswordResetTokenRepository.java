package com.ecommerce.repository;

import com.ecommerce.model.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken,Integer> {

    PasswordResetToken findByToken(String Token);
}
