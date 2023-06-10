package com.example.movieservice.model;

import com.example.movieservice.model.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Size;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Schema(description = "id filmu")
    private Long id;
    @Schema(description = "tytuł filmu")
    @Size(min = 1, max = 50)
    private String name;
    @Schema(description = "kategoria filmu")
    @Enumerated(EnumType.STRING)
    private Category category;
    @Schema(description = "dostępność filmu")
    private boolean isAvailable;
    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isAvailable() { return isAvailable;}

    public void setAvailable(boolean available) { isAvailable = available;}
}