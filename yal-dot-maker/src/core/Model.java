package core;

import GUI.Map;

public class Model {
	private boolean highlightHitbox;
	private Map map;
	private float zoom = 100;
	private boolean ctrl = false;
	
	public Model() {
		this.map = new Map();
	}
	
	public boolean isHighlightHitbox() {
		return highlightHitbox;
	}
	public void setHighlightHitbox(boolean highlightHitbox) {
		this.highlightHitbox = highlightHitbox;
	}
	public Map getMap() {
		return this.map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public float getZoom() {
		return this.zoom;
	}
	public void setZoom(float zoom) {
		this.zoom = zoom;
	}
	public boolean isCtrl() {
		return ctrl;
	}
	public void setCtrl(boolean ctrl) {
		this.ctrl = ctrl;
	}
}
