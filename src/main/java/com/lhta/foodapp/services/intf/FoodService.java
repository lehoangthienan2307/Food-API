package com.lhta.foodapp.services.intf;

import java.util.List;

import com.lhta.foodapp.dto.FoodAssignCategoryDTO;
import com.lhta.foodapp.dto.FoodDTO;
import com.lhta.foodapp.dto.FoodDetailDTO;
import com.lhta.foodapp.exceptions.CategoryNotExistException;
import com.lhta.foodapp.exceptions.FoodNotExistException;

public interface FoodService {
	List<FoodDTO> getAllFoods() throws FoodNotExistException;
	FoodDTO getFood(int id) throws FoodNotExistException;
	FoodDTO addNewFood(FoodDTO food);
	FoodDTO assignCategory(int id, FoodAssignCategoryDTO category) throws FoodNotExistException, CategoryNotExistException;
	FoodDetailDTO getFoodIngredients(int id) throws FoodNotExistException;
}
