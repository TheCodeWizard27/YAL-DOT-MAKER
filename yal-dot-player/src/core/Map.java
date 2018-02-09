package core;

import java.awt.Color;
import java.awt.image.BufferedImage;

import graphics.Camera;
import graphics.Vector2f;
import objects.Asset;
import objects.Player;
import physiks.Hitbox;

public class Map {
	private Player player;
	private Camera camera;
	private Asset[] assets;
	private Hitbox[] hitboxes;

	private BufferedImage backgroundImg;
	private Vector2f size;
	
	public Map(Vector2f startPos, String mapName) {
		this.player = Player.getInstance();
		this.camera = Camera.getInstance();
		
		this.assets = new Asset[1];
		this.hitboxes = new Hitbox[1];
		
		//debug map
		BufferedImage testImg = new BufferedImage(800,100,BufferedImage.TYPE_INT_ARGB);
		for(int y = 0; y < 100; y++) {
			for(int x = 0; x < 800; x++) {
				testImg.setRGB(x, y, new Color(255,255,0).getRGB());
			}
		}
		
		this.assets[0] = new Asset(testImg, new Vector2f(0,500), new Vector2f(800,100));
		this.hitboxes[0] = new Hitbox(0,500,800,100);
		
		this.player.setPos(0, 400);
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
	public void setAssets(Asset[] assets) {
		this.assets = assets;
	}

	public Hitbox[] getHitboxes() {
		return hitboxes;
	}
	public void setHitboxes(Hitbox[] hitboxes) {
		this.hitboxes = hitboxes;
	}

	public BufferedImage getBackgroundImg() {
		return backgroundImg;
	}
	public void setBackgroundImg(BufferedImage backgroundImg) {
		this.backgroundImg = backgroundImg;
	}
}
