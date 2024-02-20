package com.backend.blogapi.blogappbackend.servicesimpl;


import com.backend.blogapi.blogappbackend.entities.Users;
import com.backend.blogapi.blogappbackend.exceptions.ResourceNotFoundException;
import com.backend.blogapi.blogappbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements com.backend.blogapi.blogappbackend.services.UserService {
  @Autowired
  private UserRepository userRepository;

    @Override
    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<?> updateUser(Users user, int userId) {
        Users newusers = userRepository.findById(userId).orElse(null);
        if(newusers==null){
          return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
        }
        else {
          newusers.setName(user.getName());
          return new ResponseEntity<>(userRepository.save(newusers),HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> getUserById(int userId) {
        Users users = userRepository.findById(userId).orElse(null);
        if(users == null){
            throw new ResourceNotFoundException("User", "UserId", userId);
        }
        else {

            return new ResponseEntity<>(userRepository.findById(userId),HttpStatus.OK);
        }
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity<?> deleteUserById(int userId) {
        Users users = userRepository.findById(userId).orElse(null);
        if(users == null){
            throw new ResourceNotFoundException("User", "UserId", userId);
        }
        else {
            userRepository.deleteById(userId);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> deleteAllUser(){

        userRepository.deleteAll();
     return new ResponseEntity<>("All USERS HAS BEEN DELETED",HttpStatus.OK);

    }
}
