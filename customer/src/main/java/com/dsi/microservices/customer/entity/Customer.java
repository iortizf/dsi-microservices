package com.dsi.microservices.customer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dsi.microservices.customer.model.CustomerDto;

@Entity(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Integer id;	
	
	private String name;
	private String apaterno;
	private String amaterno;
	private String email;
	private String password;
	private boolean status;
	private Date created_date;
	
	public static Customer from(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setName(customerDto.getCustomerName());
		customer.setApaterno(customerDto.getApaterno());
		customer.setAmaterno(customerDto.getAmaterno());
		customer.setEmail(customerDto.getEmail());
		customer.setPassword(customerDto.getPassword());
		customer.setStatus(true);
		customer.setCreated_date(new Date());
		return customer;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getApaterno() {
		return apaterno;
	}

	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}

	public String getAmaterno() {
		return amaterno;
	}

	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	
	
	
}
