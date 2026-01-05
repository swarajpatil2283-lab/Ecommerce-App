package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class PasswordResetToken {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @id
    private Integer id;

    private @NonNull String token;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    private @NonNull User user;

    private @NonNull Date expriryDate;

    public boolean isExpired() {
        return expriryDate.before(new Date());
    }
}
