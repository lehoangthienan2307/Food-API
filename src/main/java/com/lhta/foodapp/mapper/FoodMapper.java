package com.lhta.foodapp.mapper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lhta.foodapp.dto.FoodDTO;
import com.lhta.foodapp.dto.FoodDetailDTO;
import com.lhta.foodapp.entities.FoodEntity;
import com.lhta.foodapp.entities.FoodIngredientEntity;
import com.lhta.foodapp.entities.IngredientEntity;

@Service
public class FoodMapper {
	public FoodDTO foodToFoodDTO(FoodEntity entity)
	{
		FoodDTO dto = FoodDTO.builder()
				.id(entity.getId())
				.description(entity.getDescription())
				.name(entity.getName())
				.image(entity.getImage())
				.price(entity.getPrice())
				.rating(entity.getRating())
				.createdAt(entity.getCreatedAt())
				.category(entity.getCategory() != null ? entity.getCategory().getName() : "")
				.build();
		return dto;
	}
	
	public FoodEntity foodDTOToFood(FoodDTO dto)
	{
		FoodEntity entity = new FoodEntity();
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		entity.setRating(dto.getRating());
		entity.setDescription(dto.getDescription());
		entity.setImage(dto.getImage());
		return entity;
	}

	public FoodDetailDTO foodToFoodDetailDTO(FoodEntity entity) {
		List<String> ingredients = new ArrayList<>();
		for (FoodIngredientEntity ingredientEntity : entity.getFoodIngredients()) {
			ingredients.add(ingredientEntity.getIngredient().getName());
		}
		System.out.println(ingredients.size());
		FoodDetailDTO dto = FoodDetailDTO.builder()
				.id(entity.getId())
				.description(entity.getDescription())
				.name(entity.getName())
				.image(entity.getImage())
				.price(entity.getPrice())
				.rating(entity.getRating())
				.category(entity.getCategory() != null ? entity.getCategory().getName() : "")
				.ingredients(ingredients)
				.build();
		return dto;
		
	}
	
}
