package GUI;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import graphics.Vector2f;
import map.Asset;
import map.Camera;
import map.DeathBoxes;
import map.EndBox;
import map.Hitbox;

public class Map {
	private BufferedImage player;
	private String name;
	private Vector2f size;
	private EndBox endBox;
	private Camera camera;
	private ArrayList<Asset> assets;
	private ArrayList<Hitbox> hitboxes;
	private ArrayList<DeathBoxes> deathboxes;
	private BufferedImage backgroundImage;
	
	public Map() {
		this.size = new Vector2f(800,600);
	}
	
	public BufferedImage getPlayer() {
		return player;
	}
	public void setPlayer(BufferedImage player) {
		this.player = player;
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
	public void setSize(Vector2f size) {
		this.size = size;
	}
	public EndBox getEndBox() {
		return endBox;
	}
	public void setEndBox(EndBox endBox) {
		this.endBox = endBox;
	}
	public Camera getCamera() {
		return camera;
	}
	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	public ArrayList<Asset> getAssets() {
		return assets;
	}
	public void setAssets(ArrayList<Asset> assets) {
		this.assets = assets;
	}
	public ArrayList<Hitbox> getHitboxes() {
		return hitboxes;
	}
	public void setHitboxes(ArrayList<Hitbox> hitboxes) {
		this.hitboxes = hitboxes;
	}
	public ArrayList<DeathBoxes> getDeathboxes() {
		return deathboxes;
	}
	public void setDeathboxes(ArrayList<DeathBoxes> deathboxes) {
		this.deathboxes = deathboxes;
	}
	public BufferedImage getBackgroundImage() {
		return backgroundImage;
	}
	public void setBackgroundImage(BufferedImage backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
}
