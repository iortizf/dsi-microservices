package com.dsi.microservices.loan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsi.microservices.loan.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer>{
	List<Loan> findByCustomerId(Integer customer_id);
}
