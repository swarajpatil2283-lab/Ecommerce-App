package com.ecommerce.model;

import com.ecommerce.domain.PaymentMethod;
import com.ecommerce.domain.PaymentOrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data


public class PaymentOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long amount;

    private PaymentOrderStatus status = PaymentOrderStatus.PENDING;

    private PaymentMethod paymentMethod;

    private String paymentLinked;

    @ManyToOne
    private User user;

    @OneToMany
    private Set<Order> orders = new HashSet<>();
}
