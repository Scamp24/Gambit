package com.server.core.concurrent;

/**
 * Represents a periodic or single job that can be scheduled with
 * {@code JobScheduler}
 * @author Tony Erazo
 *
 */
public abstract class Job implements Runnable {

	/**
	 * The number of cycles between consecutive executions of this job this will be
	 * the wait time before the job repeats
	 */
	private int delay;
	
	/**
	 * The initial count down time before the task initially starts this will delay once if {@code delay} has a value
	 * and delay repetitively if {@code repeatsDelay} is {@value true} and initiate the task when it reaches zero
	 */
	private int countdown = 1;
	
	/**
	 * A flag that indicates whether the job is delayed between each repetition
	 */
	private boolean repeatsDelay;
	
	/**
	 * A flag that indicates whether a job will repeat
	 */
	private boolean repeat;
	
	/**
	 * A flag that indicates whether a job will execute immediately
	 */
	private boolean immediate;
	
	/**
	 * A flag that indicates if a job is running
	 */
	private boolean running = true;
	
	public Job(int delay) throws RuntimeException {
		this.delay = delay;
		this.immediate = delay > 0 ? true : false;
		if(delay < 0) {
			throw new IllegalArgumentException("The delay cannot be a negative number!");
		}
	}
	
	/**
	 * Creates a job with a delay and flags the task if it will initially delay until the
	 * {@code delay} variable reaches zero and it will have another delay in between cycles if {@code repeatCycle} is {@value true}
	 * @param delay the count down until the task executes
	 * @param immediate will flag whether a job executes instantly {@code immediate} is {@value true}
	 */
	public Job(int delay, boolean immediate) throws RuntimeException {
		this.delay = delay;
		this.immediate = immediate;
		checkDelay(delay);
	}
	
	/**
	 * Creates a job with a delay and flags the task if it will initially delay until the
	 * {@code delay} variable reaches zero and it will have another delay in between cycles if {@code repeatCycle} is {@value true}
	 * @param delay the count down until the task executes
	 * @param immediate will flag whether a job executes instantly {@code immediate} is {@value true}
	 * @param repeatsDelay will flag whether a job repeats the delay each cycle if {@code repeatsDelay} is {@value true}
	 */
	public Job(int delay, boolean immediate, boolean repeatsDelay) {
		this(delay, immediate);
		this.repeatsDelay = repeatsDelay;
	}
	
	/**
	 * Checks whether the job is immediate
	 * @return {@value true} if it is, {@value false} if it has a delay
	 */
	public boolean isImmediate() {
		return immediate;
	}
	
	/**
	 * Checks whether a job is running
	 * @return {@value true} if it's actively executing, {@value false} if its inactive
	 */
	public boolean isRunning() {
		return running;
	}
	
	/**
	 * {@code #cycle()} should be called by {@link JobScheduler} every cycle. It updates the {@link #countdown}
	 * and calls the {@link #execute()} method if necessary.
	 * @return A flag indicating if the task is running.
	 */
	public boolean cycle() {
		System.out.println("check cycle countdown: " + countdown + " running: " + running);
		if(running && --countdown == 0) {
			System.out.println("running");
			run();
			
			if(repeatsDelay)
				countdown = delay;
		}
		return running;
	}
	
	public void setDelay(int delay) {
		this.delay = 0;
	}
	
	/**
	 * Stops the job
	 * @throws IllegalStateException if the job has already been stopped
	 */
	public void stop() {
		if(!running)
			throw new IllegalStateException("The job has already been stopped!");
		this.running = false;
	}
	
	/**
	 * Checks if the delay is a negative number and throws an exception if so
	 * @param delay the delay
	 * @throw IllegalArgumentException if the delay is negative.
	 */
	private void checkDelay(int delay) {
		if(delay <= 0)
			throw new IllegalArgumentException("The delay cannot be a negative number!");
	}

}
