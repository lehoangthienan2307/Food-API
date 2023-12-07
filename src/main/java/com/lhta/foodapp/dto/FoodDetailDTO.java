package com.lhta.foodapp.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodDetailDTO {
	private int id;
    private String name;
    private String image;
    private float price;
    private String description;
    private float rating;
    private String category;
    private List<String> ingredients;
    
}
