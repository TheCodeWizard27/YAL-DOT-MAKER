package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import constants.Menu;

public class MenuItem extends JMenuItem implements ActionListener{
	private Menu type;
	
	public MenuItem(Menu type) {
		super(type.toString().toLowerCase());
		this.addActionListener(this);
		this.type = type;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
