package GUI;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFormattedTextField;

import constants.ObjectProperty;
import core.Model;
import core.View;
import graphics.Vector2f;
import map.ElementTemplate;

public class SettingsInput extends JFormattedTextField implements PropertyChangeListener, KeyListener{
	private Model model;
	private View view;
	private ObjectProperty property;
	
	public SettingsInput(View view, Model model, ObjectProperty property) {
		super();
		this.model = model;
		this.view = view;
		
		switch(property) {
		case NAME:
			this.setValue(new String());
			this.setText(this.model.getCurrentObj().getName());
			break;
		case WIDTH:
			this.setValue(new Float(0));
			this.setText(String.valueOf(this.model.getCurrentObj().getSize().getX()));
			break;
		case HEIGHT:
			this.setValue(new Float(0));
			this.setText(String.valueOf(this.model.getCurrentObj().getSize().getY()));
			break;
		case POSX:
			this.setValue(new Float(0));
			this.setText(String.valueOf(this.model.getCurrentObj().getPos().getX()));
			break;
		case POSY:
			this.setValue(new Float(0));
			this.setText(String.valueOf(this.model.getCurrentObj().getPos().getY()));
			break;
		}
		
		this.setPreferredSize(new Dimension(200,20));
		this.model = model;
		this.property = property;
		
		this.addPropertyChangeListener(this);
		this.addKeyListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			ElementTemplate object = this.model.getCurrentObj();
			System.out.println("pressed smth dont know though");
			switch(property) {
			case NAME:
				if(object.getName() != "camera" && object.getName() != "player") {
					if(!this.view.getObjectList().getObjects().containsKey(this.getValue())) {
						object.setName(this.getValue().toString());
					}else {
						this.setText(object.getName());
					}
				}
				break;
			case WIDTH:
				if((float)this.getValue() > 0 && (float)this.getValue() <= 999999) {
					object.setSize(new Vector2f((float)this.getValue(),object.getSize().getY()));
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
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
