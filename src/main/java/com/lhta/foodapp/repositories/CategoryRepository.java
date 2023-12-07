package com.lhta.foodapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lhta.foodapp.entities.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
	List<CategoryEntity> findAll();
	CategoryEntity findById(int id);
}
