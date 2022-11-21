package com.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class DashboardController {
	
	@RequestMapping(value = "/dashboad", method = RequestMethod.GET)
    public String index() {
          return "dashboard";
    }
	
	@CrossOrigin
	//@GetMapping(path="/login", produces=MediaType.TEXT_PLAIN_VALUE)
	@PostMapping(path="/dashboard")
	public void redirect() {
		
	}
}
