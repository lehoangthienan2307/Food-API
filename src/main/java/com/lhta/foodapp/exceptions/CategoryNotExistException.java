package com.lhta.foodapp.exceptions;

public class CategoryNotExistException extends Exception {
	public CategoryNotExistException()
	{
		super("Category not exist");
	}
}
