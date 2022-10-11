package com.server.model;

/**
 * Represents a user
 * @author Tony Erazo
 *
 */

public class User {
	

	/**
	 * The name the user is addressed by
	 */
	private String username;
	
	/**
	 * Creates a user
	 * @param username the name the user is addressed by
	 */
	public User(String username) {
		this.username = username;
	}
	
	/**
	 * Gets the username of the user
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	
 }
