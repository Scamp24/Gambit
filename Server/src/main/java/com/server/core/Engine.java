package com.server.core;

import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import com.server.core.concurrent.JobScheduler;
import com.server.core.concurrent.impl.HelloWorldJob;
import com.server.net.postgre.PostgreSQLJDBC;

/**
 * The engine class is responsible for initializing the servers core
 * @author Tony Erazo 
 *	Erick (with a 'c' 'k') is here
 */
public class Engine {

	/**
	 * A logger used to report messages.
	 */
	private static Logger logger = Logger.getLogger(Engine.class.getName());
	
	/**
	 * Job service
	 */
	private static final JobScheduler jobService = new JobScheduler();
	
	private static final Engine INSTANCE = new Engine();
	
	private static final PostgreSQLJDBC databaseService = new PostgreSQLJDBC();
	
	/**
	 * Private constructor to prevent instantiation
	 */
	private Engine() {}
	
	/**
	 * Starts the engine
	 * @throws ExecutionException if a service exception occurred 
	 */
	public void start() throws ExecutionException {
		logger.info("Starting engine...");
		databaseService.connect();
		//databaseService.setEmail("wow", "wow@aol.com");
		//System.out.println(databaseService.getValue("wow", "email"));
		//jobService.schedule(new HelloWorldJob());
	}
	
	/**
	 * Gets the {@link PostgreSQLJDBC}
	 * @return {@code databaseService}
	 */
	public PostgreSQLJDBC getDatabase() {
		return databaseService;
	}
	
	/**
	 * Gets the {@link Engine} instance
	 * @return {@code INSTANCE}
	 */
	public static Engine getInstance() {
		return INSTANCE;
	}
	
	
}
