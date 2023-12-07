package com.lhta.foodapp.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "food")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String image;
    private float price;
    private String description;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    private float rating;
    @ManyToOne()
    @JoinColumn(name = "id_category")
    @JsonIgnore
    private CategoryEntity category;
    @OneToMany(mappedBy = "food")
    private List<FoodIngredientEntity> foodIngredients;
    @OneToMany(mappedBy = "food")
    private List<ReviewEntity> reviews;
}
