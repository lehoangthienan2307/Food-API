package com.lhta.foodapp.services.intf;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lhta.foodapp.dto.CategoryDTO;
import com.lhta.foodapp.dto.CategoryDetailDTO;
import com.lhta.foodapp.exceptions.CategoryNotExistException;

public interface CategoryService {
	List<CategoryDTO> getAllCategories() throws CategoryNotExistException;
	CategoryDTO getCategory(int id) throws CategoryNotExistException;
	CategoryDetailDTO getAllCategoryFoods(int id) throws CategoryNotExistException;
}
