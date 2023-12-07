package com.lhta.foodapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDTO {
	private int id;
	private String image;
    private String name;
}
