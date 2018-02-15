package GUI;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.UIManager;

import constants.ObjectType;
import core.Model;
import core.View;
import graphics.Canvas;
import graphics.Vector2f;
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
		
		if(sprite == null)
			this.setText(type.toString().toLowerCase());
			this.setIcon(UIManager.getIcon("Tree.leafIcon"));
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
			
			float zoom = this.model.getZoom()/100;
			float imgX = (canvas.getWidth()/2)-((this.model.getMap().getSize().getX()*zoom)/2);
			float imgY = (canvas.getHeight()/2)-((this.model.getMap().getSize().getY()*zoom)/2);
			double mouseX = canvas.getMousePosition().getX();
			double mouseY = canvas.getMousePosition().getY();
			
			if(mouseX >= imgX && mouseX <= imgX + this.model.getMap().getSize().getX() && mouseY >= imgY && mouseY <= imgY + this.model.getMap().getSize().getY()) {
				switch(this.type) {
				case HITBOX:
					String name = "Hitbox" + this.model.getMap().getHitboxes().size();
					Hitbox tempObj = new Hitbox(name, new Vector2f((float)(mouseX-imgX-50*zoom),(float)(mouseY-imgY-50*zoom)), new Vector2f(100,100));
					this.model.getMap().getHitboxes().add(tempObj);
					
					break;
				case DEATHBOX:
					break;
				case GOALBOX:
					break;
				case ASSET:
					break;
				}
			}
			
			this.view.getObjectList().update();
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
