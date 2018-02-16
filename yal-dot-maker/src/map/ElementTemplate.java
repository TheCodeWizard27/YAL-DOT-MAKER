package map;

import graphics.Vector2f;

public class ElementTemplate {
	private String name;
	private Vector2f pos;
	private Vector2f size;
	
	private ElementTemplate(String name, Vector2f pos, Vector2f size) {
		this.name = name;
		this.pos = new Vector2f(pos);
		this.size = new Vector2f(size);
	}
}
