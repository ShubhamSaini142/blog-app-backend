package com.backend.blogapi.blogappbackend.repositories;

import com.backend.blogapi.blogappbackend.entities.Category;
import com.backend.blogapi.blogappbackend.entities.Posts;
import com.backend.blogapi.blogappbackend.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PostRepository extends JpaRepository<Posts,Integer> {

    List<Posts> findByUsers(Users users);
    List<Posts> findByCategory(Category category);

//    ResponseEntity<?> findByUF(String keywords);
}

