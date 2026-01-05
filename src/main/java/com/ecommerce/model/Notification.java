package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private User customer;

    private String message;
    @Temporal(TemporalType.TIMESTAMP)
    private Data sentAt;
    private boolean readStatus;
}
