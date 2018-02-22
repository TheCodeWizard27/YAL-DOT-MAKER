package mode;

import java.awt.image.BufferedImage;

import graphics.Vector2f;
import map.Asset;
import map.Camera;
import map.Hitbox;
import map.Player;

/**
 * class that has map information
 * @author bschab
 *
 */
public class Map {
	private Player player;
	private Camera camera;
	private Asset[] assets;
	private Hitbox[] hitboxes;
	private Hitbox[] deathboxes;
	private Hitbox[] goalboxes;
	private Hitbox bounds;
	private BufferedImage backgroundImg;
	private Vector2f startPos;
	
	/*
	 * getters n' setters
	 */
	public Hitbox[] getDeathboxes() {
		return deathboxes;
	}
	public void setDeathboxes(Hitbox[] deathboxes) {
		this.deathboxes = deathboxes;
	}
	public Hitbox[] getGoalboxes() {
		return goalboxes;
	}
	public void setGoalboxes(Hitbox[] goalboxes) {
		this.goalboxes = goalboxes;
	}
	public void setAssets(Asset[] assets) {
		this.assets = assets;
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
	public Vector2f getStartPos() {
		return startPos;
	}
	public void setStartPos(Vector2f startPos) {
		this.startPos = startPos;
	}
}
