package map;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import graphics.Vector2f;

public class Asset extends ElementTemplate{
	private BufferedImage sprite;
	
	public Asset(BufferedImage sprite, String name, Vector2f pos, Vector2f size) {
		super(name,pos,size);
		this.sprite = sprite;
	}
	
	public Asset(String name, BufferedImage sprite, Vector2f pos) {
		super(name, pos, new Vector2f(sprite.getWidth(), sprite.getHeight()));
		this.sprite = sprite;
	}
	
	public Asset(Asset asset) {
		super(asset.getName(), asset.getPos(), asset.getSize());
		BufferedImage spriteCopy = new BufferedImage(asset.getSprite().getWidth(),asset.getSprite().getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = (Graphics2D) spriteCopy.getGraphics();
		
		g2d.scale(spriteCopy.getWidth()/size.getX(), spriteCopy.getHeight()/size.getY());
		g2d.drawImage(this.sprite,0,0,null);
		
		this.sprite = asset.getSprite();
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
}
