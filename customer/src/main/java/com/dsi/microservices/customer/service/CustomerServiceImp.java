package com.dsi.microservices.customer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.microservices.customer.api.CustomerException;
import com.dsi.microservices.customer.entity.Customer;
import com.dsi.microservices.customer.model.CustomerDto;
import com.dsi.microservices.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImp.class);
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDto findByEmailAndPwd(String email, String pwd) {
		if(!(email!=null && !email.isEmpty() 
				&& pwd!=null && !pwd.isEmpty())) {
			logger.info("El correo y la contraseña son requeridos");
			throw new CustomerException("El correo y la contraseña son requeridos","");
		}
		
		Customer customer = customerRepository.findByEmailAndPassword(email, pwd)
				.orElseThrow(()-> CustomerException.from("Usuario o contraseña son incorrectos", "404"));
		
		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustomerId(customer.getId());
		customerDto.setCustomerName(customer.getName());
		customerDto.setApaterno(customer.getApaterno());
		customerDto.setAmaterno(customer.getAmaterno());
		customerDto.setEmail(customer.getEmail());
		customerDto.setPassword(customer.getPassword());
		
		logger.info("SE RETORNA CUSTOMER");
		return customerDto;		
	}

	@Override
	public CustomerDto create(CustomerDto customerDto) {
		if(customerDto==null)
			throw new CustomerException("Datos del cliente son requeridos","");
		
		Customer customer = Customer.from(customerDto);
		
		logger.info("SE CREA CUSTOMER");
		customer = customerRepository.save(customer);
		
		customerDto.setCustomerId(customer.getId());
		customerDto.setStatus(customer.isStatus());
		
		logger.info("SE RETORNA CUSTOMER");
		return customerDto;
	}

}
