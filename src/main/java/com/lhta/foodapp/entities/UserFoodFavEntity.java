package com.lhta.foodapp.entities;

import com.lhta.foodapp.entities.id.UserFoodFavId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "user_food_fav")
@IdClass(UserFoodFavId.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFoodFavEntity {
	@Id
	private int id_user;
	@Id
	private int id_food;
	@ManyToOne
	@JoinColumn(name = "id_food")
	private FoodEntity food;
	@ManyToOne
	@JoinColumn(name = "id_user")
	private UserEntity user;
}
