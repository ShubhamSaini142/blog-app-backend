package com.backend.blogapi.blogappbackend.servicesimpl;

import com.backend.blogapi.blogappbackend.entities.Category;
import com.backend.blogapi.blogappbackend.entities.Posts;
import com.backend.blogapi.blogappbackend.entities.Users;
import com.backend.blogapi.blogappbackend.exceptions.ResourceNotFoundException;
import com.backend.blogapi.blogappbackend.repositories.CategoryRepository;
import com.backend.blogapi.blogappbackend.repositories.PostRepository;
import com.backend.blogapi.blogappbackend.repositories.UserRepository;
import com.backend.blogapi.blogappbackend.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class PostsServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Posts createPosts(Posts posts,int userId,int categoryId) {
        Users user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "UserId", userId) );
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","CategoryId",categoryId));
        posts.setImageName("default.jpg");
        posts.setAddDate(new Date());
        posts.setUsers(user);
        posts.setCategory(category);

        return postRepository.save(posts);

    }

    @Override
    public ResponseEntity<?> updatePosts(Posts posts, int postId) {
        Posts newposts = postRepository.findById(postId).orElse(null);
        if(newposts == null){
            throw new ResourceNotFoundException("Posts", "PostId", postId);
        }
        else{
            newposts.setContent(posts.getContent());
            newposts.setTitle(posts.getTitle());
            return new ResponseEntity<>(postRepository.save(newposts),HttpStatus.OK);        }
    }

    @Override
    public ResponseEntity<?> getPostsById(int postId) {
        Posts newposts = postRepository.findById(postId).orElse(null);
          if (newposts == null){
            throw new ResourceNotFoundException("Posts", "PostId", postId);
          }
          else{
              return new ResponseEntity<>(newposts,HttpStatus.OK);
          }
    }

    @Override
    public List<Posts> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public ResponseEntity<?> deletePostsById(int postId) {
        Posts newposts = postRepository.findById(postId).orElse(null);
        if(newposts == null){
            throw new ResourceNotFoundException("Posts", "PostId", postId);
        }
        else {
            postRepository.deleteById(postId);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
    }

    @Override
    public   List<Posts> getPostByCategory(int category) {
        Category category1 = categoryRepository.findById(category).orElseThrow(()-> new ResourceNotFoundException("Category","CategoryId",category));
        return postRepository.findByCategory(category1);
    }

    @Override
    public   List<Posts> getPostByUser(int userId) {
        Users users = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","UserId",userId));
        return postRepository.findByUsers(users);
    }

//    @Override
//    public ResponseEntity<?> searchPosts(String keywords) {
//        return postRepository.findByUF(keywords);
//    }
}
