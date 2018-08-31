package com.dsi.microservices.loan.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dsi.microservices.loan.service.LoanService;
import com.dsi.microservices.loan.vo.LoanVo;

@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {
	private static final Logger logger = LoggerFactory.getLogger(LoanController.class);

	@Autowired
	private LoanService loanService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LoanVo create(@RequestBody LoanVo loanVo) {
		logger.info("INICIA CREACION DE LOAN");
		return loanService.create(loanVo);
	}
	
	@GetMapping("/customer/{customerId}")
	public List<LoanVo> getLoansByCustomer(@PathVariable("customerId") Integer customerId){
		logger.info("INICIA RETORNO DE LOAN POR CUSTOMERID");
		return loanService.getLoansByCustomerId(customerId);
	}
}
