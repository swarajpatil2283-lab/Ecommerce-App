package com.ecommerce.model;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class PaymentImformation {
    @Column(name = "cardholder_name")
    private String carholderName;
    @Column(name="card_number")
    private  String cardNumber;
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    @Column(name = "cvv")
    private String cvv;
    // getters and setters
}
