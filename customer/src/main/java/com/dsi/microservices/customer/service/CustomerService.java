package com.dsi.microservices.customer.service;

import com.dsi.microservices.customer.model.CustomerDto;

public interface CustomerService {

	CustomerDto findByEmailAndPwd(String email, String pwd);
	CustomerDto create(CustomerDto customer);
}
