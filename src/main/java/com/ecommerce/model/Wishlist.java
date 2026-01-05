package com.ecommerce.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @OneToOne
    private User user;
    @ManyToMany
    private Set<Product> products =new HashSet<>();
}
