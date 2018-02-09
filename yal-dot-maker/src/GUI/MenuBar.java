package GUI;

import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import constants.Menu;

public class MenuBar {
	private JMenuBar menuBar;
	private JMenu menuDrop;
	private MenuItem[] menuItems = new MenuItem[2];
	
	public MenuBar() {
		this.menuBar = new JMenuBar();
		this.menuDrop = new JMenu("File");
		
		int i = 0;
		for(Menu menuItem : Menu.values()) {
			this.menuItems[i] = new MenuItem(menuItem);
			this.menuDrop.add(this.menuItems[i]);
			i++;
		}
		
		this.menuBar.add(this.menuDrop);
	}
	
	public JMenuBar getMenuBar() {
		return this.menuBar;
	}
}
