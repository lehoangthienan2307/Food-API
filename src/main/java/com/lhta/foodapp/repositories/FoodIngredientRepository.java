package com.lhta.foodapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lhta.foodapp.entities.FoodIngredientEntity;
import com.lhta.foodapp.entities.id.FoodIngredientId;

@Repository
public interface FoodIngredientRepository extends JpaRepository<FoodIngredientEntity, FoodIngredientId>{
	List<FoodIngredientEntity> findByFood_id(int foodId);
}
