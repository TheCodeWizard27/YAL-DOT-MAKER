package map;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import graphics.Vector2f;

/**
 * class that stores asset information
 * @author bschab
 *
 */
public class Asset {
	private BufferedImage sprite;
	private Vector2f pos;
	private Vector2f size;
	
	public Asset(BufferedImage sprite, Vector2f pos, Vector2f size) {
		this.sprite = new BufferedImage((int)sprite.getWidth(),(int)sprite.getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics2D tempG2d = (Graphics2D) this.sprite.getGraphics();
		tempG2d.scale((float)size.getX()/(float)sprite.getWidth(),(float)size.getY()/(float)sprite.getHeight());
		
		tempG2d.drawImage(sprite, 0, 0, null);
		this.pos = pos;
		this.size = size;
	}
	
	public Asset(BufferedImage sprite, float x, float y, float width, float height) {
		this.sprite = new BufferedImage((int)sprite.getWidth(),(int)sprite.getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics2D tempG2d = (Graphics2D) this.sprite.getGraphics();
		tempG2d.scale((float)width/(float)sprite.getWidth(),(float)height/(float)sprite.getHeight());
		
		tempG2d.drawImage(sprite, 0, 0, null);
		this.pos = new Vector2f(x,y);
		this.size = new Vector2f(width,height);
	}

	/**
	 * Getters 'n setters
	 * @return
	 */
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
