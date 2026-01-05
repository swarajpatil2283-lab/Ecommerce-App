package com.ecommerce.repository;

import java.util.List;

import com.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findByCategoryId(String categoryID);

    List<Category>findByLevel(Integer level);

}