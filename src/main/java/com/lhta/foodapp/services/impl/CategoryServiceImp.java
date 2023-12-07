package com.lhta.foodapp.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lhta.foodapp.dto.CategoryDTO;
import com.lhta.foodapp.dto.CategoryDetailDTO;
import com.lhta.foodapp.entities.CategoryEntity;
import com.lhta.foodapp.exceptions.CategoryNotExistException;
import com.lhta.foodapp.mapper.CategoryMapper;
import com.lhta.foodapp.repositories.CategoryRepository;
import com.lhta.foodapp.services.intf.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {
	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;
	
	@Override
	public List<CategoryDTO> getAllCategories() throws CategoryNotExistException {
		List<CategoryEntity> categoryEntities = categoryRepository.findAll();
		if (categoryEntities!=null)
		{
			List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
			categoryEntities.forEach((category) -> {
				categoryDTOs.add(categoryMapper.categoryToCategoryDTO(category));
			});
			return categoryDTOs;
		}
		else
		{
			throw new CategoryNotExistException();
		}
	}

	@Override
	public CategoryDTO getCategory(int id) throws CategoryNotExistException {
		CategoryEntity categoryEntity = categoryRepository.findById(id);
		if (categoryEntity != null)
		{
			CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(categoryEntity);
			return categoryDTO;
		}
		else
		{
			throw new CategoryNotExistException();
		}
	}

	@Override
	public CategoryDetailDTO getAllCategoryFoods(int id) throws CategoryNotExistException {
		CategoryEntity categoryEntity = categoryRepository.findById(id);
		if (categoryEntity != null)
		{
			CategoryDetailDTO categoryDetailDTO = categoryMapper.categoryToCategoryDetailDTO(categoryEntity);
			return categoryDetailDTO;
		}
		else
		{
			throw new CategoryNotExistException();
		}
	}

}
