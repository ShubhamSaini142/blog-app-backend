package com.backend.blogapi.blogappbackend.repositories;

import com.backend.blogapi.blogappbackend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
