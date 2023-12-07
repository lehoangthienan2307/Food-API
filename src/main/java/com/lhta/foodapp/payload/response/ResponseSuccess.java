package com.lhta.foodapp.payload.response;

import lombok.Data;

@Data
public class ResponseSuccess {
	private int status;
	private boolean success = true;
	private Object data;
}
