package com.dsi.microservices.login.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.microservices.login.client.CustomerApiClient;
import com.dsi.microservices.login.client.CustomerDto;
import com.dsi.microservices.login.model.LoginDto;

@Service
public class LoginServiceImp implements LoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImp.class);
	
	@Autowired
	private CustomerApiClient customerApiClient;
	
	@Override
	public LoginDto getCustomerByEmailAndPwd(String email, String password) {
		
		LoginDto loginDto  =null;
		
		logger.info("CONSULTA CUSTOMER POR EMAIL Y PASSWORD");
		CustomerDto customerDto = customerApiClient.findByEmailAndPassword(email, password);
		Optional<CustomerDto> optionalProject = Optional.ofNullable(customerDto);
		
		if(optionalProject.isPresent()) {
			loginDto  = new LoginDto();
			loginDto.setId(customerDto.getCustomerId().toString());
			loginDto.setUsuario(customerDto.getFullName());
			loginDto.setEmail(customerDto.getEmail());
			loginDto.setPass(customerDto.getPassword());
		}
		
		logger.info("RETORNA LOGIN ["+loginDto.getUsuario()+"]");
		return loginDto;
	}

}
