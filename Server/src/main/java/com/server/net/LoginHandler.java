package com.server.net;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The {@code LoginHandler} handles all in-bound login requests from the main sign in page in the gambit react application through the web
 * @author Tony Erazo
 *
 */
public class LoginHandler {

	@CrossOrigin
	@GetMapping("/login")
	@RequestMapping(value="/login_field", method=RequestMethod.POST)
	public void login(@RequestParam("username") String username, @RequestParam("password") String password) {
		
	}
}
