package com.lhta.foodapp.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lhta.foodapp.dto.FoodAssignCategoryDTO;
import com.lhta.foodapp.dto.FoodDTO;
import com.lhta.foodapp.dto.FoodDetailDTO;
import com.lhta.foodapp.entities.CategoryEntity;
import com.lhta.foodapp.entities.FoodEntity;
import com.lhta.foodapp.entities.FoodIngredientEntity;
import com.lhta.foodapp.exceptions.CategoryNotExistException;
import com.lhta.foodapp.exceptions.FoodNotExistException;
import com.lhta.foodapp.mapper.CategoryMapper;
import com.lhta.foodapp.mapper.FoodMapper;
import com.lhta.foodapp.repositories.CategoryRepository;
import com.lhta.foodapp.repositories.FoodIngredientRepository;
import com.lhta.foodapp.repositories.FoodRepository;
import com.lhta.foodapp.services.intf.FoodService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodServiceImp implements FoodService{
	private final FoodRepository foodRepository;
	private final CategoryRepository categoryRepository;
	private final FoodIngredientRepository foodIngredientRepository;
	private final FoodMapper foodMapper;
	private final CategoryMapper categoryMapper;
	@Override
	public List<FoodDTO> getAllFoods() throws FoodNotExistException {
		List<FoodEntity> foodEntities = foodRepository.findAll();
		if (foodEntities != null)
		{
			List<FoodDTO> foodDTOs = new ArrayList<FoodDTO>();
			foodEntities.forEach((food) -> {
				foodDTOs.add(foodMapper.foodToFoodDTO(food));
			});
			return foodDTOs;
		}
		else
		{
			throw new FoodNotExistException();
		}
		
	}

	@Override
	public FoodDTO getFood(int id) throws FoodNotExistException {
		FoodEntity foodEntity = foodRepository.findById(id);
		if (foodEntity != null)
		{
			FoodDTO foodDTO = foodMapper.foodToFoodDTO(foodEntity);
			return foodDTO;
		}
		else
		{
			throw new FoodNotExistException();
		}
	}

	@Override
	public FoodDTO addNewFood(FoodDTO food) {
		FoodEntity foodEntity = foodMapper.foodDTOToFood(food);
		foodEntity.setCreatedAt(LocalDateTime.now());
		foodEntity = foodRepository.save(foodEntity);
		FoodDTO dto = foodMapper.foodToFoodDTO(foodEntity);
		
		return dto;
	}

	@Override
	public FoodDTO assignCategory(int id, FoodAssignCategoryDTO category) throws FoodNotExistException, CategoryNotExistException{
		FoodEntity foodEntity = foodRepository.findById(id);
		if (foodEntity != null)
		{
			CategoryEntity categoryEntity = categoryMapper.foodAsignCategoryDTOToCategory(category);
			CategoryEntity foodCategory = categoryRepository.findById(categoryEntity.getId());
			if (foodCategory!=null)
			{
				foodEntity.setCategory(foodCategory);
				foodEntity = foodRepository.save(foodEntity);
				FoodDTO dto = foodMapper.foodToFoodDTO(foodEntity);
				return dto;
			}
			else
			{
				throw new CategoryNotExistException();
			}
			
		}
		else
		{
			throw new FoodNotExistException();
		}
	}

	@Override
	public FoodDetailDTO getFoodIngredients(int id) throws FoodNotExistException {
		//List<FoodIngredientEntity> entities = foodIngredientRepository.findByFood_id(id);
		FoodEntity foodEntity = foodRepository.findById(id);
		if (foodEntity != null)
		{
			FoodDetailDTO foodDetailDTO = foodMapper.foodToFoodDetailDTO(foodEntity);
			return foodDetailDTO;
		}
		else
		{
			throw new FoodNotExistException();
		}
	}

	

}
