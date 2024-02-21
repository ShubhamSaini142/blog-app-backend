package com.backend.blogapi.blogappbackend.controllers;

import com.backend.blogapi.blogappbackend.entities.Category;
import com.backend.blogapi.blogappbackend.entities.Users;
import com.backend.blogapi.blogappbackend.services.CategoryServices;
import com.backend.blogapi.blogappbackend.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryServices categoryServices;
    @PostMapping("/")
    public ResponseEntity<?> createCategory(@Valid @RequestBody Category category){
        return new ResponseEntity<>(categoryServices.createCategory(category), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@Valid @RequestBody Category category , @PathVariable int id){
        return categoryServices.updateCategory(category,id);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable int id){
        return categoryServices.getCategoryById(id);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllCategory(){
        return new ResponseEntity<>(categoryServices.getAllCategory(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable int id){

        return categoryServices.deleteCategoryById(id);

    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllCategory(){

        return categoryServices.deleteAllCategory();

    }

}
