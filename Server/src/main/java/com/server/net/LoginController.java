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
import com.server.core.Engine;
import com.server.net.postgre.PostgreSQLJDBC;

/**
 * The {@code LoginController} controls all in-bound login requests from the main sign in page in the gambit react application through the web
 * @author Tony Erazo
 *
 */
@RestController
public class LoginController {

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

		PostgreSQLJDBC database = Engine.getInstance().getDatabase();
		String dbEmail = database.getValue(email, "email");
		String dbPassword = database.getValue(password, "email");
		
		if(dbEmail != null && dbPassword != null) {
			
			//Credentials are verified here
			if(email.equals(dbEmail) && password.equals(dbPassword)) {
				//Accepts login here
				//return "/dashboard";
				System.out.println("login accepted");
			}
		}
		
		System.out.println("Invalid user/pass");
		
		//We assume the database values are not equal to the input values
		//Send them a message regarding an invalid attempt
	}
}
