package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import constants.ObjectType;
import core.Model;
import core.View;
import graphics.Canvas;
import graphics.Vector2f;
import map.Asset;
import map.Deathbox;
import map.ElementTemplate;
import map.EndBox;
import map.Hitbox;

/**
 * class for each element which can be placed inside the map
 * @author bschab
 *
 */
public class Element extends JLabel implements MouseMotionListener, MouseListener{
	private ObjectType type;
	private BufferedImage sprite;
	private View view;
	private Model model;
	
	/**
	 * constructor
	 * 
	 * @param type passes the object type
	 * @param sprite passes the image if it has one
	 * @param view passes information about the GUI
	 * @param model passes information about the map
	 */
	public Element(ObjectType type, BufferedImage sprite, View view, Model model) {
		super();
		this.type = type;
		this.view = view;
		this.model = model;
		
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		
		if(sprite == null) {
			this.setText(type.toString().toLowerCase());
			this.setIcon(UIManager.getIcon("Tree.leafIcon"));
		}else {
			Image tempIcon = sprite.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			
			this.setIcon(new ImageIcon(tempIcon));
			this.sprite = sprite;
		}
	}
	
	/**
	 * implemented mouse listener function which
	 * allows drag and dropping elements onto the canvas
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		Canvas canvas = this.view.getCanvas();
		
		if(canvas.getMousePosition() != null) {
			//define temporary variables
			Map map = this.model.getMap();
			float zoom = this.model.getZoom()/100;										//gets the zoom
			float imgX = (canvas.getWidth()/2)-((map.getSize().getX()*zoom)/2);			//x gets location of canvas on panel
			float imgY = (canvas.getHeight()/2)-((map.getSize().getY()*zoom)/2);		//y gets location of canvas on panel
			double mouseX = canvas.getMousePosition().getX();
			double mouseY = canvas.getMousePosition().getY();
			ElementTemplate tempObj;
			String tempName = "";
			
			//checks if mouse inside canvas
			if(mouseX >= imgX && mouseX <= imgX + map.getSize().getX()*zoom &&
					mouseY >= imgY && mouseY <= imgY + map.getSize().getY()*zoom) {
				//switches between object types
				switch(this.type) {
				case HITBOX:
					tempName = "Hitbox" + map.getHitboxes().size();
					tempObj = new Hitbox(tempName, new Vector2f((float)(mouseX-imgX-(50*zoom)),(float)(mouseY-imgY-(50*zoom))), new Vector2f(100,100));
					this.model.getMap().getHitboxes().add((Hitbox) tempObj);
					break;
				case DEATHBOX:
					tempName = "Deathbox" + map.getDeathboxes().size();
					tempObj = new Deathbox(tempName, new Vector2f((float)(mouseX-imgX-(50*zoom)),(float)(mouseY-imgY-(50*zoom))), new Vector2f(100,100));
					this.model.getMap().getDeathboxes().add((Deathbox) tempObj);
					break;
				case GOALBOX:
					tempName = "Goalbox" + map.getEndBox().size();
					tempObj = new EndBox(tempName, new Vector2f((float)(mouseX-imgX-(50*zoom)),(float)(mouseY-imgY-(50*zoom))), new Vector2f(100,100));
					this.model.getMap().getEndBox().add((EndBox) tempObj);
					break;
				case ASSET:
					tempName = "Asset" + map.getAssets().size();
					BufferedImage tempSprite;
					
					if(this.sprite == null) {
						tempSprite = new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
						
						for(int y = 0; y < 100; y++) {
							for(int x = 0; x < 100; x++) {
								tempSprite.setRGB(x, y, new Color(150,150,100).getRGB());
							}
						}
						tempObj = new Asset(tempSprite, tempName, new Vector2f((float)(mouseX-imgX-(50*zoom)),(float)(mouseY-imgY-(50*zoom))), new Vector2f(100,100),null);
					}else {
						tempObj = new Asset(this.sprite,tempName, new Vector2f((float)((mouseX-imgX-((this.sprite.getWidth()*zoom)/2))),(float)(mouseY-imgY-((this.sprite.getHeight()*zoom)/2)))
								, new Vector2f(this.sprite.getWidth(),this.sprite.getHeight()),this.getText());
					}
					
					this.model.getMap().getAssets().add((Asset) tempObj);
					break;
				default:
					tempObj = new Hitbox("Error",new Vector2f(0,0),new Vector2f(0,0));
					JOptionPane.showMessageDialog(this.view, "An error occured whit this object.","Error",JOptionPane.ERROR_MESSAGE);
				}
				
				this.model.setCurrentObj(tempObj);											//sets current object
				this.view.getObjectList().update();											//updates object list
				this.view.getObjectList().getList().setSelectedValue(tempName, true);		//selects inserted object
			}
		}
	}
	
	/**
	 * changes cursor when over drag n' dropable element
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	/**
	 * getters n' setters
	 * @return
	 */
	public ObjectType getType() {
		return this.type;
	}
	
	public BufferedImage getSprite() {
		return this.sprite;
	}
	
	/**
	 * unused functions
	 */
	@Override
	public void mouseDragged(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
}
