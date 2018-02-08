package objects;

import java.awt.image.BufferedImage;

import graphics.Vector2f;

public class Asset {
	private BufferedImage sprite;
	private Vector2f pos;
	private Vector2f size;
	
	public Asset(BufferedImage sprite, Vector2f pos, Vector2f size) {
		this.sprite = sprite;
		this.pos = pos;
		this.size = size;
	}

	public BufferedImage getSprite() {
		return sprite;
	}
	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
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
