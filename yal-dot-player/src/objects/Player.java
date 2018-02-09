package objects;

import java.awt.Color;
import java.awt.image.BufferedImage;

import graphics.Vector2f;
import physiks.Hitbox;

public class Player {
	//Constants
	public static final float MAX_SPEED = 100;
	public static final float MAX_HEIGHT = 200;
	public static final float WALK_SPEED = 5;
	public static final float JUMP_HEIGHT = 5;
	
	private static Player player;
	private Vector2f rePos;
	private Vector2f pos;
	private Vector2f speed;
	private Hitbox hitbox;
	private BufferedImage sprite;
	
	private boolean moving = false;
	private boolean inAir = false;
	private boolean jumping = false;
	
	private Player() {
		this.rePos = new Vector2f(0,0);
		this.pos = new Vector2f(0,0);
		this.speed = new Vector2f(0,0);
		this.hitbox = new Hitbox(0,0,100,100);
		this.sprite = new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
		
		//test sprite for debbuging
		for(int y = 0; y < 100; y++) {
			for(int x = 0; x < 100; x++) {
				this.sprite.setRGB(x, y, new Color(255,0,0).getRGB());
			}
		}
	}
	
	public static Player getInstance() {
		if(Player.player == null) {
			Player.player = new Player();
		}
		
		return Player.player;
	}
	
	public Vector2f getPos() {
		return this.pos;
	}
	public void setPos(float x, float y) {
		this.pos.setPos(x,y);
	}
	
	public void setXPos(float x) {
		this.pos.setX(x);
	}
	public void setYPos(float y) {
		this.pos.setY(y);
	}
	
	public Vector2f getSpeed() {
		return speed;
	}
	public void setXSpeed(float speed) {
		this.speed.setX(speed);
	}
	public void setYSpeed(float speed) {
		this.speed.setY(speed);
	}
	public Hitbox getHitbox() {
		return this.hitbox;
	}
	public BufferedImage getSprite() {
		return this.sprite;
	}
	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}

	public boolean isMoving() {
		return moving;
	}
	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public boolean isInAir() {
		return inAir;
	}
	public void setInAir(boolean inAir) {
		this.inAir = inAir;
	}

	public Vector2f getRePos() {
		return rePos;
	}
	public void setRePos(Vector2f rePos) {
		this.rePos = rePos;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	
	
}
