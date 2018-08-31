package com.dsi.microservices.login.service;

import com.dsi.microservices.login.model.LoginDto;

public interface LoginService {
	
	LoginDto getCustomerByEmailAndPwd(String email, String password);

}
