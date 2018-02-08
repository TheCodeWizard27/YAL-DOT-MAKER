package core;

import java.util.HashSet;
import java.util.Set;

public class Game {
	private boolean run = true;
	private Set<Integer> keyBuffer = new HashSet<Integer>();
	private DrawEngine drawengine;
	
	public Game() {
		this.drawengine = new DrawEngine(this);
	}
	
}
