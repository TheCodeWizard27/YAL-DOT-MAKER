package GUI;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import constants.Menu;
import core.Model;

public class MenuBar {
	private JMenuBar menuBar;
	private JMenu menuDrop;
	private MenuItem[] menuItems = new MenuItem[3];
	private JLabel hitboxLabel;
	private HitboxCheck hitboxCheckBox;
	
	public MenuBar(Model model) {
		this.menuBar = new JMenuBar();
		this.menuDrop = new JMenu("File");
		this.hitboxLabel = new JLabel("Toggle Hitbox");
		this.hitboxCheckBox = new HitboxCheck(model);
		
		int i = 0;
		for(Menu menuItem : Menu.values()) {
			this.menuItems[i] = new MenuItem(menuItem,model);
			this.menuDrop.add(this.menuItems[i]);
			i++;
		}
		
		this.menuBar.add(this.menuDrop);
		this.menuBar.add(Box.createHorizontalGlue());
		this.menuBar.add(this.hitboxLabel);
		this.menuBar.add(this.hitboxCheckBox);
	}
	
	public JMenuBar getMenuBar() {
		return this.menuBar;
	}
}
