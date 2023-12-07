package com.lhta.foodapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lhta.foodapp.entities.FoodEntity;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Integer> {
	List<FoodEntity> findAll();
	FoodEntity findById(int id);
}
