package map;

import graphics.Vector2f;

public class Hitbox {
	private String name;
	private Vector2f pos;
	private Vector2f size;
	
	public Hitbox(String name, Vector2f pos, Vector2f size) {
		this.name = name;
		this.pos = pos;
		this.size = size;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Vector2f getPos() {
		return pos;
	}
	public void setPos(Vector2f pos) {
		this.pos = pos;
	}
	public Vector2f getSize() {
		return size;
	}
	public void setSize(Vector2f size) {
		this.size = size;
	}
}
