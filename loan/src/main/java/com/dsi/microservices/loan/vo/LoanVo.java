package com.dsi.microservices.loan.vo;

public class LoanVo {
	
	private Integer loanId;
	private Integer customerId;
	private String createdDate;
	private Double amount;
	private Integer installment;
	
	public Integer getLoanId() {
		return loanId;
	}
	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
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
	
	
}
