package com.server;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.server.core.concurrent.JobScheduler;
import com.server.core.concurrent.impl.HelloWorldJob;

@SpringBootApplication
public class Server {

	/**
	 * A logger used to report messages.
	 */
	private static Logger logger = Logger.getLogger(Server.class.getName());
	
	public static void main(String[] args) {
		logger.info("Initializing gambit server...");
		
		JobScheduler scheduler = new JobScheduler();
	
		scheduler.schedule(new HelloWorldJob());
		
		SpringApplication.run(Server.class, args);
	}


}
