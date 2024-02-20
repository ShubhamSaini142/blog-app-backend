package com.backend.blogapi.blogappbackend.controllers;

import com.backend.blogapi.blogappbackend.entities.Users;
import com.backend.blogapi.blogappbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody Users user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUserDetails(@RequestBody Users user , @PathVariable int id){
        return userService.updateUser(user, id);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
       return userService.getUserById(id);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable int id){

     return userService.deleteUserById(id);

    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllUser(){

      return userService.deleteAllUser();

    }

}
