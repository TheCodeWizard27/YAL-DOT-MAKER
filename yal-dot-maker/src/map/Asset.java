package map;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import graphics.Vector2f;

public class Asset {
	private String name;
	private BufferedImage sprite;
	private Vector2f pos;
	private Vector2f size;
	
	public Asset(BufferedImage sprite, String name, Vector2f pos, Vector2f size) {
		this.setName(name);
		this.sprite = sprite;
		this.pos = pos;
		this.size = size;
	}
	
	public Asset(BufferedImage sprite, Vector2f pos) {
		this.sprite = sprite;
		this.pos = pos;
		this.size = new Vector2f(this.sprite.getWidth(), this.sprite.getHeight());
	}
	
	public void setSize(Vector2f size) {
		BufferedImage tempImg = new BufferedImage((int)this.size.getX(),(int)this.size.getY(),BufferedImage.TYPE_INT_ARGB);
		Graphics2D tempG2d = (Graphics2D) tempImg.getGraphics();
		
		tempG2d.scale(this.size.getX()/size.getX(), this.size.getY()/size.getY());
		tempG2d.drawImage(this.sprite,0,0,null);
		this.size.setVector2f(size);
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
