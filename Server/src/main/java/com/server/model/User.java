package com.server.model;

/**
 * Represents a user
 * @author Tony Erazo
 *
 */

public class User {
	
	/**
	 * LEague of legends unique global identification digit
	 */
	private long puuid;

	/**
	 * The name the user is addressed by
	 */
	private String username;
	
	/**
	 * The user credentials that contains their login details.
	 */
	private Credentials credentials;

	/**
	 * Creates a user
	 * @param username the name the user is addressed by
	 */
	public User(String username) {
		this.username = username;
	}
	
	public User(String username, Credentials credentials) {
		this(username);
		this.credentials = credentials;
	}
	
	/**
	 * Gets the username of the user
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Gets the league of legends unique identification digit
	 * @return {@code puuid}
	 */
	public long getPuuid() {
		return puuid;
	}

	/**
	 * Modifies the league of legends unique identification digit
	 * @param puuid the updated unique identification digit
	 */
	public void setPuuid(long puuid) {
		this.puuid = puuid;
	}
	
	/**
	 * Gets the users login credentials
	 * @return {@code credentials}
	 */
	public Credentials getCredentials() {
		return credentials;
	}
	

	/**
	 * Assigns new login credentials
	 * @param credentials the user email and password
	 */
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
	
 }
