package com.server.net.postgre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * The PostgreSQLJDBC class handles the connection and modification of the postgre database
 * @author Tony Erazo
 *
 */
public class PostgreSQLJDBC {

	private Connection connection;
	
	/**
	 * Connects to the POSTGRE database
	 */
	public void connect() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gambitdb", "postgres", "0000");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Database successfully created!");
	}
	
	/**
	 * Gets a specified value from the user
	 * @param email the email of the account
	 * @param type the type attempting to access
	 * @return {@code value}
	 */
	public String getValue(String email, String type) {
		if(connection != null) {
			try {
				Class.forName("org.postgresql.Driver");
				//Statement statement = connection.createStatement();
				
				String sql = "SELECT " + type
						+ " FROM usr_table" + " WHERE email = \'" + email + "\';";
				
				System.out.println(sql);
				Statement statement = connection.createStatement();
				//PreparedStatement statement = connection.prepareStatement(sql);
				//statement.setString(1, email);
				
				ResultSet result = statement.executeQuery(sql);
				
				if(result.next()) {
					System.out.println("Found result!");
					return result.getString(1);
				}
				
				result.close();
				statement.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			//return true;
		}
		else {
			throw new IllegalStateException("Connection cannot be null!");
		}
		System.out.println("none found");
		return null;
	}
	
	/**
	 * Modifies the email of the user
	 * @param username the username of the user
	 * @param email the email of the user
	 */
	public void setEmail(String username, String email) {
		if(connection != null) {
			try {
				Class.forName("org.postgresql.Driver");
				connection.setAutoCommit(false);
				
				Statement statement = connection.createStatement();
				
				String sql = "UPDATE usr_table"
						+ " SET email = \'" + email + "\'"
						+ " WHERE username = \'" + username + "\'";
				statement.executeUpdate(sql);
				statement.close();
				connection.commit();
				System.out.println("Email set!");
			} catch(Exception e) {
				e.printStackTrace();
			}
			//return true;
		}
		else {
			throw new IllegalStateException("Connection cannot be null!");
		}
	}
	
	/**
	 * Modifies the password of the user
	 * @param email the email of the user
	 * @param password the password of the user
	 */
	public void setPassword(String email, String password) {
		if(connection != null) {
			try {
				Class.forName("org.postgresql.Driver");
				connection.setAutoCommit(false);
				
				Statement statement = connection.createStatement();
				
				String sql = "UPDATE usr_table"
						+ " SET password = \'" + password + "\'"
						+ " WHERE email = \'" + email + "\'";
				statement.executeUpdate(sql);
				statement.close();
				connection.commit();
				System.out.println("Email set!");
			} catch(Exception e) {
				e.printStackTrace();
			}
			//return true;
		}
		else {
			throw new IllegalStateException("Connection cannot be null!");
		}
	}
	
	/**
	 * Modifies the users avatar picture
	 * @param email the email of the user
	 * @param avatar the image path
	 */
	public void setAvatar(String email, String avatar) {
		if(connection != null) {
			try {
				Class.forName("org.postgresql.Driver");
				connection.setAutoCommit(false);
				
				Statement statement = connection.createStatement();
				
				String sql = "UPDATE usr_table"
						+ " SET email = \'" + email + "\'"
						+ " WHERE avatar = \'" + avatar + "\'";
				statement.executeUpdate(sql);
				statement.close();
				connection.commit();
				System.out.println("Email set!");
			} catch(Exception e) {
				e.printStackTrace();
			}
			//return true;
		}
		else {
			throw new IllegalStateException("Connection cannot be null!");
		}
	}
	
	/**
	 * Modifies the users biography
	 * @param email the user email
	 * @param biography the biography description
	 */
	public void setBio(String email, String biography) {
		if(connection != null) {
			try {
				Class.forName("org.postgresql.Driver");
				connection.setAutoCommit(false);
				
				Statement statement = connection.createStatement();
				
				String sql = "UPDATE usr_table"
						+ " SET email = \'" + email + "\'"
						+ " WHERE bio = \'" + biography + "\'";
				statement.executeUpdate(sql);
				statement.close();
				connection.commit();
				System.out.println("Email set!");
			} catch(Exception e) {
				e.printStackTrace();
			}
			//return true;
		}
		else {
			throw new IllegalStateException("Connection cannot be null!");
		}
	}
	
}
