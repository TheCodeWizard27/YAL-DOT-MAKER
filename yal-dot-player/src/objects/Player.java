package objects;

import java.awt.Color;
import java.awt.image.BufferedImage;

import graphics.Vector2f;
import physiks.Hitbox;

public class Player {
	//Constants
	public static final int IN_AIR = 1;
	public static final int ON_GROUND = 0;
	
	private static Player player;
	private Vector2f pos;
	private Vector2f speed;
	private Hitbox hitbox;
	private int state = Player.ON_GROUND;
	private BufferedImage sprite;
	
	private Player() {
		this.pos = new Vector2f(0,0);
		this.speed = new Vector2f(0,0);
		this.hitbox = new Hitbox(0,0,100,100);
		this.sprite = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
		
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
	
	public Vector2f getSpeed() {
		return speed;
	}
	public void setSpeed(Vector2f speed) {
		this.speed = speed;
	}

	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
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
}
