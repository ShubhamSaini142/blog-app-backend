package com.backend.blogapi.blogappbackend.services;

import com.backend.blogapi.blogappbackend.entities.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryServices {

    Category createCategory(Category category);
    ResponseEntity<?> updateCategory(Category category, int catId);
    ResponseEntity<?> getCategoryById(int catId);
    List<Category> getAllCategory();
    ResponseEntity<?> deleteCategoryById(int catId);

    ResponseEntity<?> deleteAllCategory();
}
