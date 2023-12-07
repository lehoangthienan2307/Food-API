package com.lhta.foodapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhta.foodapp.dto.CategoryDTO;
import com.lhta.foodapp.dto.CategoryDetailDTO;
import com.lhta.foodapp.exceptions.CategoryNotExistException;
import com.lhta.foodapp.payload.response.ResponseSuccess;
import com.lhta.foodapp.services.intf.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
	private final CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<?> getAllCategories() throws CategoryNotExistException
	{
		List<CategoryDTO> categories = categoryService.getAllCategories();
		ResponseSuccess responseSuccess = new ResponseSuccess();
		responseSuccess.setData(categories);
		responseSuccess.setStatus(HttpStatus.OK.value());
		
		return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCategory(@PathVariable int id) throws CategoryNotExistException
	{
		CategoryDTO category = categoryService.getCategory(id);
		ResponseSuccess responseSuccess = new ResponseSuccess();
		responseSuccess.setData(category);
		responseSuccess.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
	}
	@GetMapping("/{id}/food")
	public ResponseEntity<?> getAllCategoryFoods(@PathVariable int id) throws CategoryNotExistException
	{
		CategoryDetailDTO categoryDetail = categoryService.getAllCategoryFoods(id);
		ResponseSuccess responseSuccess = new ResponseSuccess();
		responseSuccess.setData(categoryDetail);
		responseSuccess.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
	}
}
