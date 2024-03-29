package com.backend.blogapi.blogappbackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    @NotNull
    private String categoryTitle;

    private String categoryDescription;

    @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Posts> posts = new ArrayList<>();

}
