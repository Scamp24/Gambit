package com.server.core;

import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import com.server.core.concurrent.JobScheduler;
import com.server.core.concurrent.impl.HelloWorldJob;

/**
 * The engine class is responsible for initializing the servers core
 * @author Tony Erazo
 *
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
		jobService.schedule(new HelloWorldJob());
	}
	
	/**
	 * Gets the {@link Engine} instance
	 * @return {@code INSTANCE}
	 */
	public static Engine getInstance() {
		return INSTANCE;
	}
	
	
}
