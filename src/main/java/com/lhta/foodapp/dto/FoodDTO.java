package com.lhta.foodapp.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodDTO {
	private int id;
    private String name;
    private String image;
    private float price;
    private String description;
    private float rating;
    private String category;
    private LocalDateTime createdAt;
}
