package com.backend.blogapi.blogappbackend.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "username" ,nullable = false,length = 100)
    private String name;
    @Email(message = "Email is not in format")
    private String email;
    private String password;
    private String about;


}
