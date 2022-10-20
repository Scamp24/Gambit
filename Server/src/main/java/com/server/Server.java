package com.server;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.server.core.Engine;

@SpringBootApplication
public class Server {

	/**
	 * A logger used to report messages.
	 */
	private static Logger logger = Logger.getLogger(Server.class.getName());
	
	public static void main(String[] args) {
		logger.info("Initializing gambit server...");
		Engine.getInstance().start();
		SpringApplication.run(Server.class, args);
	}


}
