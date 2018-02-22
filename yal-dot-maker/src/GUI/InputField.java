package GUI;

import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import constants.MapProperty;

/**
 * class for changing map propertys
 * @author bschab
 *
 */
public class InputField extends JFormattedTextField implements PropertyChangeListener{
	private Map map;
	private MapProperty property;
	
	/**
	 * constructor
	 * @param map passes map information to change
	 * @param property defines which property to change
	 */
	public InputField(Map map, MapProperty property) {
		super();
		this.map = map;
		this.property = property;
		
		switch(property) {
		case NAME:
			this.setValue(map.getName());
			break;
		case WIDTH:
			this.setValue(map.getSize().getX());
			break;
		case HEIGHT:
			this.setValue(map.getSize().getY());
			break;
		}
		
		this.setPreferredSize(new Dimension(200,20));
		this.setMaximumSize(new Dimension(200,20));		
		this.addPropertyChangeListener(this);
	}
	
	/**
	 * implemented PropertyChangeListener function
	 * changes map properties
	 */
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		try {
			switch(property) {
			case NAME:
				this.map.setName(this.getText());
				break;
			case WIDTH:
				if(Float.parseFloat(this.getText()) > 0)
					this.map.getSize().setX(Float.parseFloat(this.getText()));
				else 
					JOptionPane.showMessageDialog(this,"Map width can't be less than or 0.","Error",JOptionPane.ERROR_MESSAGE);
				break;
			case HEIGHT:
				if(Float.parseFloat(this.getText()) > 0)
					this.map.getSize().setY(Float.parseFloat(this.getText()));
				else 
					JOptionPane.showMessageDialog(this,"Map height can't be less than or 0.","Error",JOptionPane.ERROR_MESSAGE);
				break;
			}
		}catch(java.lang.NumberFormatException exc){
			JFrame err = new JFrame("Error");
			err.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
}
