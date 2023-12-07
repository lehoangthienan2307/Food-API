package com.lhta.foodapp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lhta.foodapp.dto.CategoryDTO;
import com.lhta.foodapp.dto.CategoryDetailDTO;
import com.lhta.foodapp.dto.FoodAssignCategoryDTO;
import com.lhta.foodapp.dto.FoodDTO;
import com.lhta.foodapp.entities.CategoryEntity;
import com.lhta.foodapp.entities.FoodEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryMapper {
	private final FoodMapper foodMapper;
	public CategoryDTO categoryToCategoryDTO(CategoryEntity entity)
	{
		CategoryDTO dto = CategoryDTO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.image(entity.getImage())
				.build();
		return dto;
	}
	public CategoryEntity foodAsignCategoryDTOToCategory(FoodAssignCategoryDTO dto)
	{
		CategoryEntity entity = new CategoryEntity();
		entity.setId(dto.getCategory());
		return entity;
	}
	public CategoryDetailDTO categoryToCategoryDetailDTO(CategoryEntity entity)
	{	
		List<FoodDTO> foods = new ArrayList<>();
		for (FoodEntity food : entity.getFoods()) {
			foods.add(foodMapper.foodToFoodDTO(food));
		}
		CategoryDetailDTO dto = CategoryDetailDTO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.image(entity.getImage())
				.foods(foods)
				.build();
		return dto;
	}
}
