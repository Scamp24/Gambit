package com.server.net;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@Controller
public class LoginController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
          return "index";
    }
	
	@CrossOrigin
	//@GetMapping(path="/login", produces=MediaType.TEXT_PLAIN_VALUE)
	@PostMapping(path="/login")
	@RequestMapping(value="/login", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> login(@RequestBody ObjectNode json) {
		System.out.println("logging in...");
		String email = json.get("email").asText();
		String password = json.get("password").asText();
		
		System.out.println("E-mail: " + email + " Password: " + password);

		PostgreSQLJDBC database = Engine.getInstance().getDatabase();
		String dbEmail = database.getValue(email, "email");
		String dbPassword = database.getValue(email, "password");
		
		System.out.println("db email: " + dbEmail + " dbPass: " + dbPassword);
		if(dbEmail != null && dbPassword != null) {
			
			//Credentials are verified here
			if(email.equals(dbEmail) && password.equals(dbPassword)) {
				//Accepts login here
				System.out.println("login accepted");
				//String username = database.getValue(email, "username");

		        System.out.println("redirecting...");
		       
		        return ResponseEntity.created(URI.create(String.format("/login/error=%s", "0"))).body("\"{\'err\':\'0\'}\"");
		        //return "redirect:dashboard";
			}
		}
		//response.sendRedirect("http://localhost:3000/login");
		System.out.println("Invalid user/pass");
		return null;
		//We assume the database values are not equal to the input values
		//Send them a message regarding an invalid attempt
	}
}
