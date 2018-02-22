package graphics;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import GUI.Map;
import core.Model;
import core.View;
import map.Asset;
import map.Deathbox;
import map.ElementTemplate;
import map.EndBox;
import map.Hitbox;

/**
 * canvas class shows map information 
 * @author bschab
 *
 */
public class Canvas extends JPanel implements MouseListener, MouseMotionListener{
	private Model model;
	private View view;
	private JScrollPane scrollBar;
	
	/**
	 * constructor
	 * @param model of controller
	 * @param view passes needed information about GUI
	 */
	public Canvas(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
		
		this.setFocusable(true);
		this.scrollBar = new JScrollPane(this);
		this.scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setPreferredSize(new Dimension((int)this.model.getMap().getSize().getX(),(int)this.model.getMap().getSize().getY()));
	}
	
	/**
	 * overwrites paintComponent function which draws JPanel
	 */
	public void paintComponent(Graphics g) {
		//declaring	
		Graphics2D g2d = (Graphics2D) g;									//graphics of this object
		float zoom = this.model.getZoom()/100;								//current zoom level
		Map map = this.model.getMap();				
		BufferedImage display = new BufferedImage((int)(map.getSize().getX()*zoom),(int)(map.getSize().getY()*zoom),BufferedImage.TYPE_INT_ARGB);
		Graphics2D tg2d = (Graphics2D) display.getGraphics();				//graphics of display image declared above
		
		this.setPreferredSize(new Dimension((int)(map.getSize().getX()*zoom),(int)(map.getSize().getY()*zoom)));
		float imgX = (this.getWidth()/2)-((map.getSize().getX()*zoom)/2);	//x position of canvas in this object
		float imgY = (this.getHeight()/2)-((map.getSize().getY()*zoom)/2);	//y position of canvas in this object
		
		g2d.setColor(new Color(150,150,150));								//clears screen and
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());				//draws backdrop
		
		tg2d.setColor(Color.WHITE);
		tg2d.fillRect(0, 0, (int)(map.getSize().getX()*zoom), (int)(map.getSize().getY()*zoom));	//draws background of canvas
		tg2d.scale(zoom, zoom);	
		
		//drawing

		//sizes background to correct size
		BufferedImage tempBackground = new BufferedImage(map.getBackgroundImage().getWidth(),map.getBackgroundImage().getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics2D tempG2d = (Graphics2D) tempBackground.getGraphics();
		tempG2d.scale(map.getCamera().getSize().getX()/(float)tempBackground.getWidth(), map.getCamera().getSize().getY()/(float)tempBackground.getHeight());
		tempG2d.drawImage(map.getBackgroundImage(),0,0,null);
		
		tg2d.drawImage(tempBackground, (int)map.getCamera().getPos().getX(), (int)map.getCamera().getPos().getY(),null);
		//
		
		//draws map information to display
		for(Asset asset : map.getAssets()) {
			tg2d.drawImage(asset.getSprite(), (int)asset.getPos().getX(), (int)asset.getPos().getY(), null);
		}
		
		tg2d.drawImage(map.getPlayer().getSprite(),(int)map.getPlayer().getPos().getX(),(int)map.getPlayer().getPos().getY(),null);
		
		if(this.model.isHighlightHitbox()) {
			for(Hitbox hitbox : map.getHitboxes()) {
				tg2d.setColor(new Color(255,0,255));
				tg2d.drawRect((int)hitbox.getPos().getX(), (int)hitbox.getPos().getY(), (int)hitbox.getSize().getX(), (int)hitbox.getSize().getY());
			}
			for(EndBox goal : map.getEndBox()) {
				tg2d.setColor(new Color(0,255,0));
				tg2d.drawRect((int)goal.getPos().getX(), (int)goal.getPos().getY(), (int)goal.getSize().getX(), (int)goal.getSize().getY());
			}
			for(Deathbox deathbox : map.getDeathboxes()) {
				tg2d.setColor(new Color(255,0,0));
				tg2d.drawRect((int)deathbox.getPos().getX(), (int)deathbox.getPos().getY(), (int)deathbox.getSize().getX(), (int)deathbox.getSize().getY());
			}
			tg2d.setColor(new Color(50,50,150));
			
			tg2d.drawRect((int)map.getCamera().getPos().getX(), (int)map.getCamera().getPos().getY(), 
					(int)map.getCamera().getSize().getX(), (int)map.getCamera().getSize().getY());
		}
		//end drawing
		
		g2d.drawImage(display, (int)imgX, (int)imgY, null);
	}
	
	/**
	 * @return returns canvas intergrated in JScrollPane
	 */
	public JScrollPane getCanvas() {
		return this.scrollBar;
	}

	/**
	 * implemented MouseMotionListener functions
	 * handles the moving of images
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.model.getCurrentObj() != null) {
			float zoom = this.model.getZoom()/100;
			float displayX = (this.getWidth()/2)-((this.model.getMap().getSize().getX()*zoom)/2);
			float displayY = (this.getHeight()/2)-((this.model.getMap().getSize().getY()*zoom)/2);
			
			ElementTemplate tempEle = this.model.getCurrentObj();
			float newX = e.getX() - displayX;
			float newY = e.getY() - displayY;
			
			tempEle.setPos(new Vector2f(newX - (tempEle.getSize().getX()*zoom)/2,newY - (tempEle.getSize().getY()*zoom)/2));
			this.view.getTabs().addObjectSettings();
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		this.requestFocus();
		if(this.model.getCurrentObj() != null) {
			
			float zoom = this.model.getZoom()/100;
			float objX = this.model.getCurrentObj().getPos().getX() + (this.getWidth()/2)-((this.model.getMap().getSize().getX()*zoom)/2);
			float objY = this.model.getCurrentObj().getPos().getY() + (this.getHeight()/2)-((this.model.getMap().getSize().getY()*zoom)/2);
			if(e.getX() >= objX && e.getX() <= objX + this.model.getCurrentObj().getSize().getX()*zoom &&
					e.getY() >= objY && e.getY() <= objY + this.model.getCurrentObj().getSize().getY()*zoom) {
				this.setCursor(new Cursor(Cursor.MOVE_CURSOR));
			}else {
				this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}
	}
	
	/**
	 * unused functions
	 */
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}
