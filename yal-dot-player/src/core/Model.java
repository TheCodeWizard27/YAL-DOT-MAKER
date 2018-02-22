package core;

import mode.Map;
import mode.Mode;
import mode.TitleScreen;

/**
 * class that has information about the game
 * @author bschab
 *
 */
public class Model {
	private boolean run = true;
	private Mode mode;
	private Map map;
	private TitleScreen titleScreen;
	private boolean hitboxVisible;

	/**
	 * getters n' setters
	 * @return
	 */
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public Mode getMode() {
		return mode;
	}
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	public TitleScreen getTitleScreen() {
		return titleScreen;
	}
	public void setTitleScreen(TitleScreen titleScreen) {
		this.titleScreen = titleScreen;
	}
	public boolean isHitboxVisible() {
		return hitboxVisible;
	}
	public void setHitboxVisible(boolean hitboxVisible) {
		this.hitboxVisible = hitboxVisible;
	}

	public boolean shouldRun() {
		return this.run;
	}
	public void setRun(boolean run) {
		this.run = run;
	}
}
