package com.dsi.microservices.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsi.microservices.customer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	Optional<Customer> findByEmailAndPassword(String email, String password);
}
