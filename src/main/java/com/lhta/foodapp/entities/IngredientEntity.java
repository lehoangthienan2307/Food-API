package com.lhta.foodapp.entities;

import java.util.Set;

import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ingredient")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "ingredient")
    private Set<FoodIngredientEntity> foodIngredients;
}
