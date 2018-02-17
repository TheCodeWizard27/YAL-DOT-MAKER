package GUI;

import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

import constants.MapProperty;

public class InputField extends JFormattedTextField implements PropertyChangeListener{
	private Map map;
	private MapProperty property;
	
	public InputField(Map map, MapProperty property) {
		super();
		
		switch(property) {
		case NAME:
			this.setValue("Custom Map");
			break;
		case WIDTH:
			this.setValue(new Float(500));
			break;
		case HEIGHT:
			this.setValue(new Float(500));
			break;
		}
		
		this.setPreferredSize(new Dimension(200,20));
		this.setMaximumSize(new Dimension(200,20));
		this.map = map;
		this.property = property;
		
		this.addPropertyChangeListener(this);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		try {
			switch(property) {
			case NAME:
				this.map.setName(this.getText());
				break;
			case WIDTH:
				this.map.getSize().setX(Float.parseFloat(this.getText()));
				break;
			case HEIGHT:
				this.map.getSize().setY(Float.parseFloat(this.getText()));
				break;
			}
		}catch(java.lang.NumberFormatException exc){
			JFrame err = new JFrame("Error");
			err.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
}
