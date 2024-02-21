package com.backend.blogapi.blogappbackend.servicesimpl;

import com.backend.blogapi.blogappbackend.entities.Category;
import com.backend.blogapi.blogappbackend.entities.Users;
import com.backend.blogapi.blogappbackend.exceptions.ResourceNotFoundException;
import com.backend.blogapi.blogappbackend.repositories.CategoryRepository;
import com.backend.blogapi.blogappbackend.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryServices {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public ResponseEntity<?> updateCategory(Category category, int catId) {
        Category category1 = categoryRepository.findById(catId).orElse(null);
        if(category1 == null){
            return new ResponseEntity<>("Category Not Found", HttpStatus.NOT_FOUND);        }
        else {
            category1.setCategoryTitle(category.getCategoryTitle());
            category1.setCategoryDescription(category.getCategoryDescription());
            return new ResponseEntity<>(categoryRepository.save(category1),HttpStatus.OK);
        }

    }

    @Override
    public ResponseEntity<?> getCategoryById(int catId) {
        Category category = categoryRepository.findById(catId).orElse(null);
        if(category == null){
            throw new ResourceNotFoundException("Category", "CategoryId", catId);
        }
        else {
            return new ResponseEntity<>(categoryRepository.findById(catId),HttpStatus.OK);
        }
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public ResponseEntity<?> deleteCategoryById(int catId) {
        Category category= categoryRepository.findById(catId).orElse(null);
        if(category == null){
            throw new ResourceNotFoundException("Category", "CategoryId", catId);
        }
        else {
            categoryRepository.deleteById(catId);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> deleteAllCategory() {
        categoryRepository.deleteAll();
        return new ResponseEntity<>("All CATEGORIES HAS BEEN DELETED",HttpStatus.OK);    }
}
