package map;

import graphics.Vector2f;

public class Hitbox extends ElementTemplate{

	protected Hitbox(String name, Vector2f pos, Vector2f size) {
		super(name, pos, size);
	}
	
	public Hitbox(Hitbox hitbox) {
		super(hitbox.getName(), hitbox.getPos(), hitbox.getSize());
	}

}
