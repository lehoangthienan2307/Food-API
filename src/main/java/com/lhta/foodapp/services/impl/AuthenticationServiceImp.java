package com.lhta.foodapp.services.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lhta.foodapp.configurations.JwtService;
import com.lhta.foodapp.entities.UserEntity;
import com.lhta.foodapp.payload.request.AuthenticationRequest;
import com.lhta.foodapp.payload.request.RegisterRequest;
import com.lhta.foodapp.repositories.UserRepository;
import com.lhta.foodapp.services.intf.AuthenticationService;
import com.lhta.foodapp.utils.Constants.Role;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImp implements AuthenticationService{
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	@Override
	public String register(RegisterRequest request) {
		UserEntity user = UserEntity.builder()
				.fullname(request.getFullName())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(Role.USER)
				.build();
		userRepository.save(user);
		String jwtToken = jwtService.generateToken(user);
		return jwtToken;
	}

	@Override
	public String authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getEmail(), request.getPassword())
				);
		UserEntity user = userRepository.findByEmail(request.getEmail())
				.orElseThrow();
		String jwtToken = jwtService.generateToken(user);
		return jwtToken;
	}

}
