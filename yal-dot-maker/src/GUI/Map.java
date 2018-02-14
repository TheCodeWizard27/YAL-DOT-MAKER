package GUI;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import graphics.Vector2f;
import map.Asset;
import map.Camera;
import map.Deathbox;
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
	private ArrayList<Deathbox> deathboxes;
	private BufferedImage backgroundImage;
	
	public Map() {
		this.name = "Costum Map";
		this.size = new Vector2f(500,500);
	}
	
	public BufferedImage getPlayer() {
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
	public EndBox getEndBox() {
		return endBox;
	}
	public Camera getCamera() {
		return camera;
	}
	
	public ArrayList<Asset> getAssets() {
		return assets;
	}
	public void addAsset(Asset asset) {
		this.assets.add(asset);
	}
	public void rmAsset(Asset asset) {
		this.assets.remove(asset);
	}
	
	public ArrayList<Hitbox> getHitboxes() {
		return hitboxes;
	}
	public void addHitbox(Hitbox hitbox) {
		this.hitboxes.add(hitbox);
	}
	public void rmHitbox(Hitbox hitbox) {
		this.hitboxes.remove(hitbox);
	}
	
	public ArrayList<Deathbox> getDeathboxes() {
		return deathboxes;
	}
	public void addDeathbox(Deathbox deathbox) {
		this.deathboxes.add(deathbox);
	}
	public void rmDeathbox(Deathbox deathbox) {
		this.deathboxes.remove(deathbox);
	}
	
	public BufferedImage getBackgroundImage() {
		return backgroundImage;
	}
	public void setBackgroundImage(BufferedImage backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
}
