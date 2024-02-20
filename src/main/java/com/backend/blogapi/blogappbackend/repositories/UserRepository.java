package com.backend.blogapi.blogappbackend.repositories;

import com.backend.blogapi.blogappbackend.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users ,Integer> {
}
