package core;

import GUI.Map;

public class Model {
	private boolean highlightHitbox;
	private Map map;
	
	public Model() {
		
	}
	
	public boolean isHighlightHitbox() {
		return highlightHitbox;
	}
	public void setHighlightHitbox(boolean highlightHitbox) {
		this.highlightHitbox = highlightHitbox;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
}
