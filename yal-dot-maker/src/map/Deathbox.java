package map;

import graphics.Vector2f;

/**
 * class for the Deathbox objects
 * @author bschab
 *
 */
public class Deathbox extends ElementTemplate{

	public Deathbox(String name, Vector2f pos, Vector2f size) {
		super(name, pos, size);
	}
	
	/**
	 * copy constructor
	 * @param deathbox
	 */
	public Deathbox(Deathbox deathbox) {
		super(deathbox.getName(), new Vector2f(deathbox.getPos()),new Vector2f(deathbox.getSize()));
	}

}
