package com.gambit.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.annotation.Transient;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	private String email;
	private String username;
	private String firstName;
	private String lastName;
	private String password;

	private String photo;
	private String biography;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhotos() {
		return photo;
	}

	public void setPhotos(String photos) {
		this.photo = photos;
	}

	@Transient
	public String getPhotoImagePath() {
		if(photo == null || id == null)
			return null;
		return "/user-photos/" + id + "/" + photo;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

}
