package mode;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import graphics.Vector2f;
import map.Asset;
import map.Camera;
import map.Hitbox;
import map.Player;

public class Map {
	private Player player;
	private Camera camera;
	private Asset[] assets = new Asset[2];
	private Hitbox[] hitboxes = new Hitbox[2];
	private Hitbox bounds;
	private BufferedImage backgroundImg;
	
	public Map() {
		this.player = new Player(new Vector2f(0,0));
		this.camera = new Camera(new Vector2f(0,0), new Vector2f(400,200));
		this.bounds = new Hitbox(0,0,600,600);
		
		//debugging
		try {
			this.assets[0] = new Asset(ImageIO.read(new File("C:\\Users\\benny\\Desktop\\Unbenannt2.png")),new Vector2f(0,100),new Vector2f(100,32));
		} catch (IOException e) {
			BufferedImage errImg = new BufferedImage(16,32,BufferedImage.TYPE_INT_ARGB);
			for(int y = 0; y < 32; y++) {
				for(int x = 0; x < 100; x++) {
					errImg.setRGB(x, y, new Color(255,0,255).getRGB());
				}
			}
			this.assets[0] = new Asset(errImg,new Vector2f(0,100),new Vector2f(100,32));
		}
		
		try {
			this.assets[1] = new Asset(ImageIO.read(new File("C:\\Users\\benny\\Desktop\\Unbenannt2.png")),new Vector2f(200,100),new Vector2f(100,32));
		} catch (IOException e) {
			BufferedImage errImg = new BufferedImage(16,32,BufferedImage.TYPE_INT_ARGB);
			for(int y = 0; y < 32; y++) {
				for(int x = 0; x < 100; x++) {
					errImg.setRGB(x, y, new Color(255,0,255).getRGB());
				}
			}
			this.assets[1] = new Asset(errImg,new Vector2f(200,100),new Vector2f(100,32));
		}
		
		this.hitboxes[0] = new Hitbox(0,106,100,25);
		this.hitboxes[1] = new Hitbox(200,106,100,25);
	}

	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Camera getCamera() {
		return camera;
	}
	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	public Asset[] getAssets() {
		return assets;
	}
	public void setAsstes(Asset[] asstes) {
		this.assets = asstes;
	}
	public Hitbox[] getHitboxes() {
		return hitboxes;
	}
	public void setHitboxes(Hitbox[] hitboxes) {
		this.hitboxes = hitboxes;
	}
	public Hitbox getBounds() {
		return bounds;
	}
	public void setBounds(Hitbox bounds) {
		this.bounds = bounds;
	}

	public BufferedImage getBackgroundImg() {
		return backgroundImg;
	}

	public void setBackgroundImg(BufferedImage backgroundImg) {
		this.backgroundImg = backgroundImg;
	}
}
