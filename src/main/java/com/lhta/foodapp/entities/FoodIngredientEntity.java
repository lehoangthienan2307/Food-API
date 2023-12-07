package com.lhta.foodapp.entities;

import jakarta.persistence.IdClass;
import com.lhta.foodapp.entities.id.FoodIngredientId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "food_ingredient")
@IdClass(FoodIngredientId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodIngredientEntity {
	@Id
	private int id_food;
	@Id
	private int id_ingredient;
	@ManyToOne()
	@JoinColumn(name = "id_food", insertable = false, updatable = false)
	private FoodEntity food;
	@ManyToOne()
	@JoinColumn(name = "id_ingredient", insertable = false, updatable = false)
	private IngredientEntity ingredient;
}
