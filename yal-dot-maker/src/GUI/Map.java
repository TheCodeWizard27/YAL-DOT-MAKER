package GUI;

import java.awt.List;
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
		
	}
}
