package com.backend.blogapi.blogappbackend.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "users" , cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Posts> posts = new ArrayList<>();


}
