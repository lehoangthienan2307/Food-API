package com.lhta.foodapp.entities;

import com.lhta.foodapp.entities.id.OrderDetailId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "order_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(OrderDetailId.class)
public class OrderDetailEntity {
	@Id
	private int id_order;
	@Id
	private int id_food;
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "id_order", insertable = false, updatable = false)
	private OrderEntity order;
	@ManyToOne
	@JoinColumn(name = "id_food", insertable = false, updatable = false)
	private FoodEntity food;
}
