package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFormattedTextField;

import constants.ObjectProperty;
import core.Model;
import core.View;
import graphics.Vector2f;
import map.ElementTemplate;

public class SettingsInput extends JFormattedTextField implements FocusListener, KeyListener{
	private Model model;
	private View view;
	private ObjectProperty property;
	
	public SettingsInput(View view, Model model, ObjectProperty property) {
		this.model = model;
		this.view = view;
		this.property = property;
		
		switch(property) {
		case NAME:
			this.setValue(this.model.getCurrentObj().getName());
			break;
		case WIDTH:
			this.setValue(this.model.getCurrentObj().getSize().getX());
			break;
		case HEIGHT:
			this.setValue(this.model.getCurrentObj().getSize().getY());
			break;
		case POSX:
			this.setValue(this.model.getCurrentObj().getPos().getX());
			break;
		case POSY:
			this.setValue(this.model.getCurrentObj().getPos().getY());
			break;
		}
		
		this.setPreferredSize(new Dimension(200,20));
		this.setMaximumSize(new Dimension(200,20));
		this.addKeyListener(this);
		this.addFocusListener(this);
	}


	public void update() {
			if(this.model.getCurrentObj() != null) {
				ElementTemplate object = this.model.getCurrentObj();
		
				switch(property) {
				case NAME:
					if(object.getName() != "Camera" && object.getName() != "Player") {
						if(!this.view.getObjectList().getObjects().containsKey(this.getText())) {
							object.setName(this.getText());
						}else {
							this.setValue(object.getName());
						}
					}else {
						this.setValue(object.getName());
					}
					break;
				case WIDTH:
					if((float)this.getValue() > 0 && (float)this.getValue() <= 999999) {
						object.setSize(new Vector2f((float)this.getValue(),object.getSize().getY()));
					}else {
						
					}
					break;
				case HEIGHT:
					if((float)this.getValue() > 0 && (float)this.getValue() <= 999999) {
						object.setSize(new Vector2f(object.getSize().getX(),(float)this.getValue()));
					}
					break;
				case POSX:
					if((float)this.getValue() > 0 && (float)this.getValue() <= 999999) {
						object.setPos(new Vector2f((float)this.getValue(),object.getPos().getY()));
					}
					break;
				case POSY:
					if((float)this.getValue() > 0 && (float)this.getValue() <= 999999) {
						object.setPos(new Vector2f(object.getPos().getX(),(float)this.getValue()));
					}
					break;
				}
				this.view.getObjectList().update();
				this.view.getObjectList().getList().setSelectedValue(object.getName(),true);
			}
	}

	

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		this.update();
	}

	

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
			this.update();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}
	@Override
	public void keyPressed(KeyEvent arg0) {}
	@Override
	public void focusGained(FocusEvent arg0) {}
}