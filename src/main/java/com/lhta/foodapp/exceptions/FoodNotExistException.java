package com.lhta.foodapp.exceptions;

public class FoodNotExistException extends Exception {
	public FoodNotExistException()
	{
		super("Food not exist");
	}
}

