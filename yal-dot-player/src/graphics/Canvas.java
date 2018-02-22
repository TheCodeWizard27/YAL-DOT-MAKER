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
import mode.Mode;
import mode.TitleScreen;

/**
 * canvas class that handles the object drawing
 * @author bschab
 *
 */
public class Canvas extends JPanel{
	private Model model;
	private DrawEngine drawEngine;
	private TitleScreen titleScreen;
	
	/**
	 * constructor
	 * @param model passes model information
	 * @param drawEngine passes drawEngine
	 */
	public Canvas(Model model, DrawEngine drawEngine) {
		this.model = model;
		this.titleScreen = new TitleScreen(model);
		this.drawEngine = drawEngine;
		this.add(titleScreen.getTitle());
	}
	
	/**
	 * switches between game modes
	 * @param g
	 */
	public void paintComponent(Graphics g) {
		if(this.model.getMode() == Mode.TITLESCREEN) {
			this.titleScreen.getTitle().setVisible(true);
			
		}else if(this.model.getMode() == Mode.IN_GAME){
			this.titleScreen.getTitle().setVisible(false);
			if(this.model.getMap() == null) {
				this.showLoadingScreen(g);
			}else {
				this.drawEngine.requestFocusInWindow();
				this.showGame(g);
			}
		}
	}
	
	/**
	 * temporary loading screen
	 * @param g
	 */
	public void showLoadingScreen(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, this.drawEngine.getWidth(), this.drawEngine.getHeight());

		g2d.setColor(Color.WHITE);
		g2d.drawString("Loading...", 0, 10);
	}
	
	/**
	 * draws game onto screen
	 * @param g graphics of Canvas
	 */
	public void showGame(Graphics g) {
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
		
		//Background resizing
		BufferedImage backImg = new BufferedImage(map.getBackgroundImg().getWidth(),map.getBackgroundImg().getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics2D backG2d = (Graphics2D) backImg.getGraphics();
		
		backG2d.scale((float)cameraWidth/(float)backImg.getWidth(), (float)cameraHeight/(float)backImg.getHeight());
		backG2d.drawImage(map.getBackgroundImg(),0,0,null);
		
		g2d.drawImage(backImg, 0, 0, null);
		//
		
		for (Asset asset : map.getAssets()) {
			g2d.drawImage(asset.getSprite(), (int)asset.getPos().getX()-cX,(int)asset.getPos().getY()-cY,null);
		}
		
		g2d.drawImage(player.getSprite(), (int)player.getPos().getX()-cX, (int)player.getPos().getY()-cY,null);
		
		/* Debug function
		if(this.model.isHitboxVisible()) {
			g2d.setColor(new Color(0,255,0,150));
			g2d.drawRect((int)player.getHitbox().getPos().getX()-cX, (int)player.getHitbox().getPos().getY()-cY, (int)player.getHitbox().getSize().getX(), (int)player.getHitbox().getSize().getY());
			
			g2d.setColor(new Color(255,0,255,150));
			for(Hitbox hitbox : map.getHitboxes()) {
				g2d.drawRect((int)hitbox.getPos().getX()-cX,(int)hitbox.getPos().getY()-cY,(int)hitbox.getSize().getX(),(int)hitbox.getSize().getY());
			}
		}
		*/
		//scales canvas to screen
		mainG2d.scale((float)this.drawEngine.getWidth()/(float)cameraWidth, (float)this.drawEngine.getHeight()/(float)cameraHeight);
		
		mainG2d.drawImage(tempImg, 0, 0, null);
	}
}
