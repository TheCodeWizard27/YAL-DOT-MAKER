package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import constants.ObjectModes;

public class ObjectListBtn extends JButton implements ActionListener{

	private ObjectModes type;
	
	public ObjectListBtn(ObjectModes type) {
		super(type.toString().toLowerCase());
		this.type = type;
		this.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
