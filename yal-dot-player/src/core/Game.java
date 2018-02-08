package core;

import java.util.HashSet;
import java.util.Set;

public class Game {
	private boolean run = true;
	private Set<Integer> keyBuffer = new HashSet<Integer>();
	private DrawEngine drawengine;
	private EventHandler eventHandler;
	
	public Game() {
		this.drawengine = DrawEngine.getInstance(this);
		this.eventHandler = EventHandler.getInstance(this);
		this.drawengine.addKeyListener(this.eventHandler);
		
		//main loop
		while(this.run) {
			double startTime = System.nanoTime();
			
			//inner loop
			this.handleInput(System.nanoTime()-startTime);
			this.update(System.nanoTime()-startTime);
			this.drawengine.repaint();
		}
	}
	
	/**
	 * Updates objects and checks hitboxes
	 * @param delta		the time it took for the last action
	 */
	public void update(double delta) {
		//System.out.printf("%f : Time Passed\n", (float)delta/100);
	}
	
	/**
	 * Handels input it got from Eventhandler
	 * @param delta		the time it took for the last action
	 */
	public void handleInput(double delta) {
		try {
		for(int key : this.keyBuffer) {
			switch(key) {
			default:
				System.out.println(key);
			}
		}
		}catch(java.util.ConcurrentModificationException e){
			System.out.println("Error Error Error");
		}
		
	}
	
	public void addInput(int key) {
		this.keyBuffer.add(key);
	}
	public void removeInput(int key) {
		this.keyBuffer.remove(key);
	}
}
