package com.server;

import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.server.core.Engine;

@SpringBootApplication
@CrossOrigin(maxAge = 3600)
@Configuration
@EnableWebMvc
public class Server {

	/**
	 * A logger used to report messages.
	 */
	private static Logger logger = Logger.getLogger(Server.class.getName());
	
	public static void main(String[] args) {
		logger.info("Initializing gambit server...");
		try {
			Engine.getInstance().start();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		SpringApplication.run(Server.class, args);
	}


}
