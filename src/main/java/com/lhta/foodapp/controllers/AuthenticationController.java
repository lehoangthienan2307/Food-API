package com.lhta.foodapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhta.foodapp.payload.request.AuthenticationRequest;
import com.lhta.foodapp.payload.request.RegisterRequest;
import com.lhta.foodapp.payload.response.ResponseSuccess;
import com.lhta.foodapp.services.intf.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	private final AuthenticationService authService;
	@PostMapping("/register")
	public ResponseEntity<?> register(
			@RequestBody RegisterRequest request)
	{
		String jwt = authService.register(request);
		ResponseSuccess responseSuccess = new ResponseSuccess();
		responseSuccess.setData(jwt);
		responseSuccess.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> register(
			@RequestBody AuthenticationRequest request)
	{
		String jwt = authService.authenticate(request);
		ResponseSuccess responseSuccess = new ResponseSuccess();
		responseSuccess.setData(jwt);
		responseSuccess.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
	}
}
