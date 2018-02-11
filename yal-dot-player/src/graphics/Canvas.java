package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import core.DrawEngine;
import core.Model;
import map.Asset;
import map.Camera;
import map.Hitbox;
import map.Player;
import mode.Map;

public class Canvas extends JPanel{
	private Model model;
	private DrawEngine drawEngine;
	
	public Canvas(Model model, DrawEngine drawEngine) {
		this.model = model;
		this.drawEngine = drawEngine;
	}
	
	/**
	 * Draws all visible things to screen
	 * @param g
	 */
	public void paintComponent(Graphics g) {
		Graphics2D mainG2d = (Graphics2D) g;
		Map map = this.model.getMap();
		Player player = map.getPlayer();
		Camera camera = map.getCamera();
		
		int cameraWidth = (int)camera.getSize().getX();
		int cameraHeight = (int)camera.getSize().getY();
		
		int cX = (int)camera.getPos().getX();
		int cY = (int)camera.getPos().getY();
		
		BufferedImage tempImg = new BufferedImage(cameraWidth,cameraHeight,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = (Graphics2D) tempImg.getGraphics();
		
		for (Asset asset : map.getAssets()) {
			g2d.drawImage(asset.getSprite(), (int)asset.getPos().getX()-cX,(int)asset.getPos().getY()-cY,null);
		}
		
		g2d.drawImage(player.getSprite(), (int)player.getPos().getX()-cX, (int)player.getPos().getY()-cY,null);
		
		if(this.model.isHitboxVisible()) {
			g2d.setColor(new Color(0,255,0,150));
			g2d.drawRect((int)player.getHitbox().getPos().getX()-cX, (int)player.getHitbox().getPos().getY()-cY, 16, 32);
			
			g2d.setColor(new Color(255,0,255,150));
			for(Hitbox hitbox : map.getHitboxes()) {
				g2d.drawRect((int)hitbox.getPos().getX()-cX,(int)hitbox.getPos().getY()-cY,(int)hitbox.getSize().getX(),(int)hitbox.getSize().getY());
			}
		}
		
		mainG2d.scale((float)this.drawEngine.getWidth()/(float)cameraWidth, (float)this.drawEngine.getHeight()/(float)cameraHeight);
		
		mainG2d.drawImage(tempImg, 0, 0, null);
	}
}
