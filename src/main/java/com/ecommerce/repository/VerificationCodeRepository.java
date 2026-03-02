package com.ecommerce.repository;

import com.ecommerce.model.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface VerificationCodeRepository extends JpaRepository<VerificationCode,Long> {
    static VerificationCode findEmail(String email) {
        return null;
    }

    static UserDetails loadUserByUsername(String username) {
        return null;
    }

    VerificationCode findByEmail(String email);
    VerificationCode findByOtp(String otp);
}
