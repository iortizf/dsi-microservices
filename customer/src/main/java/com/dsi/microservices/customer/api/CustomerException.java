package com.dsi.microservices.customer.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerException extends RuntimeException {
	private static final Logger logger = LoggerFactory.getLogger(CustomerException.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -7601760864655281780L;
	
	private final String id;

	public CustomerException(String message, String id) {
		super(message);
		logger.info("CustomerException: Datos del cliente son requeridos");
		this.id = id;
	}

	public static CustomerException from(String message, String id) {
		logger.info("CustomerException: Usuario o contraseña son incorrectos");
		return new CustomerException(message, id);
	}

	public String getId() {
		return id;
	}
}
