package com.lhta.foodapp.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "review")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String content;
	private int rate;
	@Column(name = "created_at")
    private LocalDateTime createdAt;
	@ManyToOne
	@JoinColumn(name = "id_food")
	private FoodEntity food;
	@ManyToOne
	@JoinColumn(name = "id_user")
	private UserEntity user;
}
