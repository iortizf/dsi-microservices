package com.dsi.microservices.login.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsi.microservices.login.model.LoginDto;
import com.dsi.microservices.login.service.LoginService;

@RestController
@RequestMapping("/api/v1/auths")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	
	@GetMapping("/{email}/{password}")
	public LoginDto login(@PathVariable("email") String email, 
			@PathVariable("password") String password) {
		
		logger.info("INICIA RETORNO DE AUTHS POR EMAIL Y PASSWORD");
		return loginService.getCustomerByEmailAndPwd(email, password);
	}
	
	
}
