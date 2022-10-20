package com.server.core;

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
	private Engine() {
		jobService.schedule(new HelloWorldJob());
	}
	
	public void start() {
		logger.info("Starting engine...");
	}
	
	public static Engine getInstance() {
		return INSTANCE;
	}
	
	
}
