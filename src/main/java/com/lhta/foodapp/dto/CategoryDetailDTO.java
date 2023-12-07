package com.lhta.foodapp.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDetailDTO {
	private int id;
	private String image;
    private String name;
    private List<FoodDTO> foods;
}
