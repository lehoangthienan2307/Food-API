package com.lhta.foodapp.entities.id;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodIngredientId implements Serializable {
	private int id_food;
    private int id_ingredient;
}
