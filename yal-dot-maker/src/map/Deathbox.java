package map;

import graphics.Vector2f;

public class Deathbox extends Hitbox{

	public Deathbox(String name, Vector2f pos, Vector2f size) {
		super(name, pos, size);
	}
	
	public Deathbox(Deathbox deathbox) {
		super(deathbox.getName(), new Vector2f(deathbox.getPos()),new Vector2f(deathbox.getSize()));
	}

}
