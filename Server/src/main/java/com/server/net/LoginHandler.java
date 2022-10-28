package com.server.net;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@code LoginHandler} handles all in-bound login requests from the main sign in page in the gambit react application through the web
 * @author Tony Erazo
 *
 */
@RestController
public class LoginHandler {

	@CrossOrigin
	@GetMapping(path="/login", produces=MediaType.TEXT_PLAIN_VALUE)
	@RequestMapping(value="/login/")//, method=RequestMethod.POST)
	public void login(@RequestParam("email") String email, @RequestParam("password") String password) {
		System.out.println("logging in...");
		
		//TODO we will return a string to the dashboard url path if login is successful
	}
}
