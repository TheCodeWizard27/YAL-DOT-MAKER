package map;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import graphics.Vector2f;

public class Player extends ElementTemplate{
	private BufferedImage sprite;
	
	public Player(Vector2f pos, Vector2f size) {
		super("Player", pos,size);
		try {
			this.sprite = ImageIO.read(new File("src/textures/unnamed.png"));
		} catch (IOException e) {
			//add error
		}
		this.size = new Vector2f(this.sprite.getWidth(), this.sprite.getHeight());
	}
	
	public void setSize(Vector2f size) {
		BufferedImage tempImg = new BufferedImage(this.sprite.getWidth(),this.sprite.getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = (Graphics2D) tempImg.getGraphics();
		g2d.scale(this.sprite.getWidth()/size.getX(), this.sprite.getHeight()/size.getY());
		g2d.drawImage(this.sprite, 0, 0, null);
		
		this.sprite = tempImg;
		this.size = new Vector2f(size);
	}
	
	public BufferedImage getSprite() {
		return this.sprite;
	}
}
