package com.dsi.microservices.loan.api;


public class LoanException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -679214731935590158L;
	
	private final String id;

	public LoanException(String message, String id) {
		super(message);
		this.id = id;
	}

	public static LoanException from(String message, String id) {
		return new LoanException(message, id);
	}

	public String getId() {
		return id;
	}
}
