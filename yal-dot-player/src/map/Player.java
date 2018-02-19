package map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import graphics.Vector2f;

public class Player {
	public static final float JUMP_HEIGHT = 0.75f;
	public static final float MAX_JUMP_HEIGHT = 6;
	public static final float WALK_SPEED = 0.25f;
	public static final float MAX_WALK_SPEED = 6;
	
	private BufferedImage sprite;
	private Vector2f pos;
	private Vector2f size;
	private Vector2f speed;
	private Hitbox hitbox;
	
	private boolean movR = false;
	private boolean movL = false;
	private boolean jumping = false;
	private boolean inAir = false;
	
	public Player(Vector2f pos, Vector2f size) {
		this.pos = pos;
		this.speed = new Vector2f(0,0);
		this.size = new Vector2f(size);
		this.hitbox = new Hitbox(this.pos,this.size);
		
		try {
			this.sprite = ImageIO.read(new File("src/textures/unnamed.png"));
			BufferedImage tempImg = new BufferedImage((int)size.getX(),(int)size.getY(),BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = (Graphics2D) tempImg.getGraphics();
			g2d.scale(size.getX()/this.sprite.getWidth(), size.getY()/this.sprite.getHeight());
			g2d.drawImage(this.sprite, 0, 0, null);
			
			this.sprite = tempImg;
		} catch (IOException e) {
			BufferedImage errImg = new BufferedImage((int)this.size.getX(),(int)this.size.getY(),BufferedImage.TYPE_INT_ARGB);
			for(int y = 0; y < this.size.getY(); y++) {
				for(int x = 0; x < this.size.getX(); x++) {
					errImg.setRGB(x, y, new Color(255,0,255).getRGB());
				}
			}
			this.sprite = errImg;
		}
	}
	
	public void update() {
		this.hitbox.setPos(this.pos);
		this.pos.addToBoth(this.speed);
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
	public Vector2f getPos() {
		return pos;
	}
	public void setPos(Vector2f pos) {
		this.pos.setVector2f(pos);
	}
	public Vector2f getSpeed() {
		return speed;
	}
	public void setSpeed(Vector2f speed) {
		this.speed = speed;
	}
	public Hitbox getHitbox() {
		return hitbox;
	}
	public void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}
	public boolean isMovR() {
		return movR;
	}
	public void setMovR(boolean movR) {
		this.movR = movR;
	}
	public boolean isMovL() {
		return movL;
	}
	public void setMovL(boolean movL) {
		this.movL = movL;
	}
	public boolean isJumping() {
		return jumping;
	}
	public void setJumping(boolean jump) {
		this.jumping = jump;
	}
	public boolean isInAir() {
		return inAir;
	}
	public void setInAir(boolean inAir) {
		this.inAir = inAir;
	}
}
