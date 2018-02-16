package map;

import graphics.Vector2f;

public class ElementTemplate {
	protected String name;
	protected Vector2f pos;
	protected Vector2f size;
	
	protected ElementTemplate(String name, Vector2f pos, Vector2f size) {
		this.name = name;
		this.pos = new Vector2f(pos);
		this.size = new Vector2f(size);
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
