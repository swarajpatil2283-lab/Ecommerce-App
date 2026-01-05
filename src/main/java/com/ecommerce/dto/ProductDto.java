package com.ecommerce.dto;

import com.ecommerce.model.Category;
import com.ecommerce.model.Review;
import com.ecommerce.model.Seller;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDto {

    private Long id;

    private String title;

    private String description;

    private int mrpPrice;

    private int sellingPrice;

    private int discountPercent;

    private int quantity;

    private String color;

    private List<String> images = new ArrayList<>();

    private int numRatings;

    private LocalDateTime createdAt;

    private String Sizes;

}