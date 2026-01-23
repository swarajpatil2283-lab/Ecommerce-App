package com.ecommerce.service.Impl;

import com.ecommerce.model.HomeCategory;

import com.ecommerce.repository.HomeCategoryRepository;

import com.ecommerce.service.HomeCategoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

@RequiredArgsConstructor


public class HomeCategoryServiceImpl implements HomeCategoryService{
    private final HomeCategoryRepository homeCategoryRepository;


    @Override
    public HomeCategory createCategory(HomeCategory categories) {
        return homeCategoryRepository.save(categories);
    }

    @Override
    public List<HomeCategory> createCategories(List<HomeCategory> categories) {
        if (homeCategoryRepository.findAll().isEmpty()) {

            return homeCategoryRepository.saveAll(categories);
        }

        return homeCategoryRepository.findAll();

    }

    @Override
    public List<HomeCategory> getAllCategories() {
        return homeCategoryRepository.findAll();
    }

    @Override
    public HomeCategory updateCategory(HomeCategory categories, Long id) throws Exception {
        HomeCategory existingCategory = homeCategoryRepository.findById(id)

                .orElseThrow(() -> new Exception("Category not found"));

        if(categories.getImage()!=null){

            existingCategory.setImage(categories.getImage());

        }

        if(categories.getCategoryId()!=null){

            existingCategory.setCategoryId(categories.getCategoryId());

        }

        return homeCategoryRepository.save(existingCategory);

    }
    }

