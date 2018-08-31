package com.dsi.microservices.login.api;

public class LoginException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -982239313502667707L;
	
	private final String id;

	public LoginException(String message, String id) {
		super(message);
		this.id = id;
	}

	public static LoginException from(String message, String id) {
		return new LoginException(message, id);
	}

	public String getId() {
		return id;
	}

}
