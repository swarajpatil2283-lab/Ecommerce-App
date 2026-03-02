package com.ecommerce.request;

import lombok.Data;

@Data
public class CreateHomeCategoriesRequest {
    private String categoryId;
    private String name;
    private String image;
}
