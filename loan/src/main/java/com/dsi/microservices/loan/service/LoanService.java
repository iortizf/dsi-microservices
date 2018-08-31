package com.dsi.microservices.loan.service;

import java.util.List;

import com.dsi.microservices.loan.vo.LoanVo;

public interface LoanService {

	LoanVo create(LoanVo loanVo);
	List<LoanVo> getLoansByCustomerId(Integer cutomerId);
}
