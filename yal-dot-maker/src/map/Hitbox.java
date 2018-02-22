package map;

import graphics.Vector2f;
/**
 * class for hitbox objects
 * @author bschab
 *
 */
public class Hitbox extends ElementTemplate{

	public Hitbox(String name, Vector2f pos, Vector2f size) {
		super(name, pos, size);
	}
	
	public Hitbox(Hitbox hitbox) {
		super(hitbox.getName(), hitbox.getPos(), hitbox.getSize());
	}

}
