package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import core.Game;
import core.Map;
import objects.Asset;
import physiks.Hitbox;

public class Canvas extends JPanel{
	private Game game;
	
	public Canvas(Game game) {
		this.game = game;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		BufferedImage img = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
		Map map = this.game.getMap();
		Graphics2D imgG2d = (Graphics2D) img.createGraphics();
		
		for(Asset asset : map.getAssets()) {
			imgG2d.drawImage(asset.getSprite(),(int)asset.getPos().getX(),(int)asset.getPos().getY(), null);
		}
		imgG2d.drawImage(map.getPlayer().getSprite(),(int)map.getPlayer().getPos().getX(),(int)map.getPlayer().getPos().getY(),null);
		
		if(this.game.isHitboxVisible()) {
			for(Hitbox hitbox : map.getHitboxes()) {
				imgG2d.setColor(Color.CYAN);
				imgG2d.drawRect((int)hitbox.getPos().getX(), (int)hitbox.getPos().getY(), (int)hitbox.getSize().getX(), (int)hitbox.getSize().getY());
			}
		}
		
		g2d.drawImage(img, 0, 0, null);
		
	}
}
