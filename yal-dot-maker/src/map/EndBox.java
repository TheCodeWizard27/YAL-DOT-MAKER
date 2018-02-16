package map;

import graphics.Vector2f;

public class EndBox extends ElementTemplate{

	public EndBox(String name, Vector2f pos, Vector2f size) {
		super(name, pos, size);
	}
	
	public EndBox(EndBox endbox) {
		super(endbox.getName(),endbox.getPos(),endbox.getSize());
	}

}
