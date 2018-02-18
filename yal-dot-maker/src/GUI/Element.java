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

public class Element extends JLabel implements MouseMotionListener, MouseListener{
	private ObjectType type;
	private BufferedImage sprite;
	private View view;
	private Model model;
	
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
	
	public ObjectType getType() {
		return this.type;
	}
	
	public BufferedImage getSprite() {
		return this.sprite;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		Canvas canvas = this.view.getCanvas();
		
		if(canvas.getMousePosition() != null) {
			
			Map map = this.model.getMap();
			float zoom = this.model.getZoom()/100;
			float imgX = (canvas.getWidth()/2)-((map.getSize().getX()*zoom)/2);
			float imgY = (canvas.getHeight()/2)-((map.getSize().getY()*zoom)/2);
			double mouseX = canvas.getMousePosition().getX();
			double mouseY = canvas.getMousePosition().getY();
			ElementTemplate tempObj;
			String tempName = "";
			
			if(mouseX >= imgX && mouseX <= imgX + map.getSize().getX()*zoom &&
					mouseY >= imgY && mouseY <= imgY + map.getSize().getY()*zoom) {
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
				}
				
				this.model.setCurrentObj(tempObj);
				this.view.getObjectList().update();
				this.view.getObjectList().getList().setSelectedValue(tempName, true);
			}
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {

	}
	@Override
	public void mouseMoved(MouseEvent e) {
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
	}
}
