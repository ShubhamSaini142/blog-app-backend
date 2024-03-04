package com.backend.blogapi.blogappbackend.controllers;

import com.backend.blogapi.blogappbackend.entities.Posts;
import com.backend.blogapi.blogappbackend.entities.Users;
import com.backend.blogapi.blogappbackend.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class JobController {

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{catId}/create")
    public ResponseEntity<?> createPost(@RequestBody Posts posts,@PathVariable int userId ,@PathVariable int catId){
        return new ResponseEntity<>(postService.createPosts(posts,userId,catId), HttpStatus.CREATED);

    }

    @PutMapping("/{postId}/update")
    public  ResponseEntity<?> updatePost(@RequestBody Posts posts,@PathVariable int postId){
        return postService.updatePosts(posts,postId);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> getPostById(@PathVariable int postId){
        return postService.getPostsById(postId);
    }

    @GetMapping("/getallposts")
    public List<Posts> getAllPost(){
        return postService.getAllPosts();
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<?> deletePostById(@PathVariable int postId){
        return postService.deletePostsById(postId);
    }

    @GetMapping("/category/{catId}")
    public   List<Posts> getPostByCategory(@PathVariable int catId){
        return postService.getPostByCategory(catId);
    }

    @GetMapping("/user/{userId}")
    public   List<Posts> getPostByUser(@PathVariable int userId){
        return postService.getPostByUser(userId);
    }

//    @GetMapping("/{string}")
//    public ResponseEntity<?> getPostByUser(@PathVariable String string){
//        return postService.searchPosts(string);
//    }


}
