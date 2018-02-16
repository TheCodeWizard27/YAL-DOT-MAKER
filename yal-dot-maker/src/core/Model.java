package core;

import GUI.Map;
import graphics.Vector2f;
import map.ElementTemplate;

public class Model {
	private boolean highlightHitbox;
	private Map map;
	private float zoom = 100;
	private boolean ctrl = false;
	private ElementTemplate currentObj;
	private Vector2f setPos;
	
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
	public ElementTemplate getCurrentObj() {
		return currentObj;
	}
	public void setCurrentObj(ElementTemplate currentObj) {
		this.currentObj = currentObj;
	}
}
