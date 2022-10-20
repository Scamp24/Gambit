package com.server.core.concurrent;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A class which schedules the execution of {@link Job}s
 * @author Tony Erazo
 *
 */
public final class JobScheduler implements Runnable {
	
	/**
	 * A logger used to report error messages.
	 */
	private static Logger logger = Logger.getLogger(JobScheduler.class.getName());

	/**
	 * Constant cycle period of 800 milliseconds of a single cycle.
	 */
	private static final int CYCLE_PERIOD = 800;
	
	public static final int POOL_SIZE = Runtime.getRuntime().availableProcessors()/ 4;

	/**
	 * The {@link ExecutorService} which schedules calls to the
	 * {@link #run() method}
	 */
	private final ScheduledExecutorService service = Executors.newScheduledThreadPool(POOL_SIZE);
	
	/**
	 * A list of active jobs
	 */
	private final List<Job> jobs = new ArrayList<Job>();
	
	/**
	 * A double queue of jobs that still need to be added this queue will not accept {@value null} elements
	 */
	private final Queue<Job> newJobs = new ArrayDeque<Job>();
	
	/**
	 * Creates and starts the job scheduler.
	 */
	public JobScheduler() {
		service.scheduleAtFixedRate(this, 0, CYCLE_PERIOD, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * Stops the job scheduler.
	 */
	public void shutdown() {
		service.shutdown();
		
		try {
			//Wait for all jobs to finish
			service.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		}
		catch(InterruptedException e) {
			logger.log(Level.SEVERE, "Exception during shut down ", e);
		}
	}
	
	/**
	 * Schedules the specified job. If this scheduler has been stopped with {@link #terminate()} ,etjpd tje tasl
	 * will not be executed or garbage-collected
	 * @param job the job to schedule
	 */
	public void schedule(final Job job) {
		if(job.isImmediate()) {
			service.execute(job);
		}
		
		//Will lock the list of new jobs for a thread safe operation to avoid race conditions
		synchronized(newJobs) {
			logger.info("Adding new job ");
			newJobs.add(job);
		}
	}
	
	/**
	 * This method is automatically called every cycle by the
	 */
	@Override
	public void run() {
		synchronized(newJobs) {
			Job job;
			while((job = newJobs.poll()) != null)
				jobs.add(job);
		}
		
		Iterator<Job> iterator = jobs.iterator();
		while(iterator.hasNext()) {
			Job job = iterator.next();
			try {
				if(!job.cycle()) {
					iterator.remove();
				}
			}
			catch (Throwable t) {
				logger.log(Level.SEVERE, "Exception during job execution", t);
			}
		}
	}

}
