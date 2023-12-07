package com.lhta.foodapp.controllers;

import java.util.List;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhta.foodapp.dto.FoodAssignCategoryDTO;
import com.lhta.foodapp.dto.FoodDTO;
import com.lhta.foodapp.dto.FoodDetailDTO;
import com.lhta.foodapp.exceptions.CategoryNotExistException;
import com.lhta.foodapp.exceptions.FoodNotExistException;
import com.lhta.foodapp.payload.response.ResponseSuccess;
import com.lhta.foodapp.services.intf.FoodService;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/food")
public class FoodController {
	private final FoodService foodService;
	
	@GetMapping
	public ResponseEntity<?> getAllFoods() throws FoodNotExistException
	{
		List<FoodDTO> foodDTOs = foodService.getAllFoods();
		
		ResponseSuccess responseSuccess = new ResponseSuccess();
		responseSuccess.setData(foodDTOs);
		responseSuccess.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getFood(@PathVariable int id) throws FoodNotExistException
	{
		FoodDTO foodDTO = foodService.getFood(id);
		ResponseSuccess responseSuccess = new ResponseSuccess();
		responseSuccess.setData(foodDTO);
		responseSuccess.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addNewFood(@RequestBody @Validated FoodDTO food)
	{
		FoodDTO foodDTO = foodService.addNewFood(food);
		ResponseSuccess responseSuccess = new ResponseSuccess();
		responseSuccess.setData(foodDTO);
		responseSuccess.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
	}
	
	@PostMapping("/{id}/assign-category")
	public ResponseEntity<?> assignCategory(@PathVariable int id, @RequestBody @Validated FoodAssignCategoryDTO category) throws FoodNotExistException, CategoryNotExistException
	{
		FoodDTO foodDTO = foodService.assignCategory(id, category);
		ResponseSuccess responseSuccess = new ResponseSuccess();
		responseSuccess.setData(foodDTO);
		responseSuccess.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/ingredient")
	public ResponseEntity<?> getFoodIngredients(@PathVariable int id) throws FoodNotExistException
	{
		FoodDetailDTO foodDTO = foodService.getFoodIngredients(id);
		ResponseSuccess responseSuccess = new ResponseSuccess();
		responseSuccess.setData(foodDTO);
		responseSuccess.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
	}
}
