package com.dsi.microservices.customer.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.dsi.microservices.customer.model.CustomerDto;
import com.dsi.microservices.customer.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@GetMapping("/{email}/{password}")
	public CustomerDto findByUsuarioAndPass(@PathVariable("email") String email,
			@PathVariable("password") String password) {
		logger.info("INICIA RETORNO DE CUSTOMER POR EMAIL Y PASSWORD");
		return customerService.findByEmailAndPwd(email, password);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerDto create(@RequestBody CustomerDto customer) {
		logger.info("INICIA CREACION DE CUSTOMER POR EMAIL Y PASSWORD");
		return customerService.create(customer);
	}
}
