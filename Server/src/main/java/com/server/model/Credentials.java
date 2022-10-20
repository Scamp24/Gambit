package com.server.model;

/**
 * The {@code Credentials} class provides a wrapper for an email and password required to login the system
 * @author Tony Erazo
 *
 */
public class Credentials {

	/**
	 * The login email
	 */
	private String email;
	
	/**
	 * The login password
	 */
	private String password;

	/**
	 * Creates a Credentials
	 * @param email the email to login
	 * @param password the password to login
	 */
	public Credentials(String email, String password) {
		this.email = email;
		this.password = password;
	}

	/**
	 * Gets the email
	 * @return {@code enauk}
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Changes the email
	 * @param email the updated email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password
	 * @return {@code password}
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Updates the login password
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
