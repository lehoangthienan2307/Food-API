package com.lhta.foodapp.services.intf;

import com.lhta.foodapp.payload.request.AuthenticationRequest;
import com.lhta.foodapp.payload.request.RegisterRequest;

public interface AuthenticationService {
	public String register(RegisterRequest request);
	public String authenticate(AuthenticationRequest request);
}
