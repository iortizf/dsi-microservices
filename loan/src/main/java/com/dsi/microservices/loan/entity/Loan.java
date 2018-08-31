package com.dsi.microservices.loan.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dsi.microservices.loan.vo.LoanVo;

@Entity(name="loan")
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Integer loan_id;
	@Column(name="customer_id")
	private Integer customerId;
	private Double amount;
	private Integer installment;
	private Date created_date;
	
	public static Loan from(LoanVo loanVo) {
		
		Loan loan = new Loan();
		loan.setAmount(loanVo.getAmount());
		loan.setInstallment(loanVo.getInstallment());
		loan.setCustomerId(loanVo.getCustomerId());
		loan.setCreated_date(new Date());
		
		return loan;
	}
	
	public Integer getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(Integer loan_id) {
		this.loan_id = loan_id;
	}
	
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getInstallment() {
		return installment;
	}
	public void setInstallment(Integer installment) {
		this.installment = installment;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	} 
	
	

}
