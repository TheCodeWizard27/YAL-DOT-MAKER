package GUI;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import graphics.Vector2f;
import map.Asset;
import map.Camera;
import map.Deathbox;
import map.EndBox;
import map.Hitbox;
import map.Player;

public class Map {
	private Player player = new Player(new Vector2f(0, 0), new Vector2f(38, 64));
	private String name;
	private Vector2f size;
	private ArrayList<EndBox> endBox = new ArrayList<EndBox>();
	private Camera camera = new Camera(new Vector2f(0, 0), new Vector2f(450, 300));
	private ArrayList<Asset> assets = new ArrayList<Asset>();
	private ArrayList<Hitbox> hitboxes = new ArrayList<Hitbox>();
	private ArrayList<Deathbox> deathboxes = new ArrayList<Deathbox>();
	private BufferedImage backgroundImage = new BufferedImage(450, 300, BufferedImage.TYPE_INT_ARGB);

	public Map() {
		this.name = "Costum Map";
		this.size = new Vector2f(500, 500);
	}

	public Player getPlayer() {
		return player;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vector2f getSize() {
		return size;
	}

	public ArrayList<EndBox> getEndBox() {
		return endBox;
	}

	public Camera getCamera() {
		return camera;
	}

	public ArrayList<Asset> getAssets() {
		return assets;
	}

	public ArrayList<Hitbox> getHitboxes() {
		return hitboxes;
	}

	public ArrayList<Deathbox> getDeathboxes() {
		return deathboxes;
	}

	public BufferedImage getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(BufferedImage backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
}
