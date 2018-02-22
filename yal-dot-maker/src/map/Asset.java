package map;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import graphics.Vector2f;

/**
 * class for saving assets
 * @author bschab
 *
 */
public class Asset extends ElementTemplate{
	private BufferedImage sprite;
	private String spriteName;
	
	//constructors
	public Asset(BufferedImage sprite, String name, Vector2f pos, Vector2f size, String spriteName) {
		super(name,pos,size);
		this.sprite = sprite;
		this.spriteName = spriteName;
	}
	public Asset(String name, BufferedImage sprite, Vector2f pos) {
		super(name, pos, new Vector2f(sprite.getWidth(), sprite.getHeight()));
		this.sprite = sprite;
	}
	
	/**
	 * copy constructor
	 * @param asset
	 */
	public Asset(Asset asset) {
		super(asset.getName(), asset.getPos(), asset.getSize());
		BufferedImage spriteCopy = new BufferedImage(asset.getSprite().getWidth(),asset.getSprite().getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = (Graphics2D) spriteCopy.getGraphics();
		
		g2d.scale(spriteCopy.getWidth()/size.getX(), spriteCopy.getHeight()/size.getY());
		g2d.drawImage(asset.getSprite(),0,0,null);
		
		this.sprite = spriteCopy;
		this.spriteName = asset.getSpriteName();
	}
	
	/**
	 * sets size of asset and changes image size aswell
	 */
	public void setSize(Vector2f size) {
		BufferedImage tempImg = new BufferedImage((int)size.getX(),(int)size.getY(),BufferedImage.TYPE_INT_ARGB);
		Graphics2D tempG2d = (Graphics2D) tempImg.getGraphics();
		
		tempG2d.scale(size.getX()/this.size.getX(), size.getY()/this.size.getY());
		tempG2d.drawImage(this.sprite,0,0,null);
		this.sprite = tempImg;
		this.size.setVector2f(size);
	}
	
	/**
	 * getters n' setters
	 * @return
	 */
	public BufferedImage getSprite() {
		return sprite;
	}
	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}
	public String getSpriteName() {
		return spriteName;
	}
	public void setSpriteName(String spriteName) {
		this.spriteName = spriteName;
	}
}
