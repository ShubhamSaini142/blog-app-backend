package com.backend.blogapi.blogappbackend.services;

import com.backend.blogapi.blogappbackend.entities.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    Users createUser(Users user);
    ResponseEntity<?> updateUser(Users user, int userId);
    ResponseEntity<?> getUserById(int userId);
    List<Users> getAllUsers();
    ResponseEntity<?> deleteUserById(int userId);

    ResponseEntity<?> deleteAllUser();
}
