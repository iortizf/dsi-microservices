package com.dsi.microservices.loan.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.microservices.loan.entity.Loan;
import com.dsi.microservices.loan.repository.LoanRepository;
import com.dsi.microservices.loan.vo.LoanVo;

@Service
public class LoanServiceImp implements LoanService {
	private static final Logger logger = LoggerFactory.getLogger(LoanServiceImp.class);
	
	@Autowired
	private LoanRepository loanRepository;

	@Override
	public LoanVo create(LoanVo loanVo) {
		
		Loan  loan = Loan.from(loanVo);
		
		logger.info("SE CREA LOAN");
		loan = loanRepository.save(loan);
		
		loanVo.setLoanId(loan.getLoan_id());		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 		
		loanVo.setCreatedDate(format.format(loan.getCreated_date()));
		
		logger.info("SE RETORNA INFO DE LOAN CREADO");
		return loanVo;
	}

	@Override
	public List<LoanVo> getLoansByCustomerId(Integer cutomerId) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		List<Loan> loans = loanRepository.findByCustomerId(cutomerId);

		if (loans != null && !loans.isEmpty())
			return loans.stream().map(loan -> {
				LoanVo loanVo = new LoanVo();
				loanVo.setLoanId(loan.getLoan_id());
				loanVo.setCustomerId(loan.getCustomerId());
				loanVo.setCreatedDate(format.format(loan.getCreated_date()));
				loanVo.setInstallment(loan.getInstallment());
				loanVo.setAmount(loan.getAmount());
				
				return loanVo;
			}).collect(Collectors.toList());
		
		logger.info("SE RETORNA LISTA DE LOAN");
		return new ArrayList<>();
	}

}
