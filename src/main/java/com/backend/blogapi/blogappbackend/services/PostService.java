package com.backend.blogapi.blogappbackend.services;

import com.backend.blogapi.blogappbackend.entities.Category;
import com.backend.blogapi.blogappbackend.entities.Posts;
import com.backend.blogapi.blogappbackend.entities.Users;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    Posts createPosts(Posts posts,int userId,int categoryId);
    ResponseEntity<?> updatePosts(Posts posts, int postId);
    ResponseEntity<?> getPostsById(int postId);
    List<Posts> getAllPosts();
    ResponseEntity<?> deletePostsById(int postId);

    List<Posts> getPostByCategory(int catId);

    List<Posts> getPostByUser(int userId);

//    ResponseEntity<?> searchPosts(String keywords);
}
