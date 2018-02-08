package core;

import java.util.HashSet;
import java.util.Set;

public class Game {
	private boolean run = true;
	private Set<Integer> keyBuffer = new HashSet<Integer>();
	private DrawEngine drawengine;
	
	public Game() {
		this.drawengine = DrawEngine.getDrawEngine(this);
		
		//main loop
		while(this.run) {
			double startTime = System.nanoTime();
			
			//inner loop
			this.update(System.nanoTime()-startTime);
			this.handleInput(System.nanoTime()-startTime);
		}
	}
	
	public void update(double delta) {
		System.out.printf("%f : Time Passed\n", (float)delta/100);
	}
	
	public void handleInput(double delta) {
		
	}
}
