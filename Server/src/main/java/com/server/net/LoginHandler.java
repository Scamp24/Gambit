package com.server.net;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * The {@code LoginHandler} handles all in-bound login requests from the main sign in page in the gambit react application through the web
 * @author Tony Erazo
 *
 */
@RestController
public class LoginHandler {

	@GetMapping("/")
    public String index() {
          return "login";
    }
	
	@CrossOrigin
	//@GetMapping(path="/login", produces=MediaType.TEXT_PLAIN_VALUE)
	//@PostMapping(path="/login")
	@RequestMapping(value="/login", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void login(@RequestBody ObjectNode json) {
		System.out.println("logging in...");
		String email = json.get("email").asText();
		String password = json.get("password").asText();
		
		System.out.println("E-mail: " + email + " Password: " + password);
		//TODO we will return a string to the dashboard url path if login is successful
		
		//return "/dashboard";
	}
}
