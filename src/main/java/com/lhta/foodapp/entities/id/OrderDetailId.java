package com.lhta.foodapp.entities.id;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailId implements Serializable{
	private int id_order;
    private int id_food;
}
