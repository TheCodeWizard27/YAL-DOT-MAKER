package core;

import java.util.HashSet;
import java.util.Set;

public class Game {
	private boolean run = true;
	private Set<Integer> keyBuffer = new HashSet<Integer>();
	private DrawEngine drawengine;
	
	public Game() {
		this.drawengine = DrawEngine.getInstance(this);
		
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
		System.out.printf("%f : Time Passed\n", (float)delta/100);
	}
	
	/**
	 * Handels input it got from Eventhandler
	 * @param delta		the time it took for the last action
	 */
	public void handleInput(double delta) {
		
	}
}
