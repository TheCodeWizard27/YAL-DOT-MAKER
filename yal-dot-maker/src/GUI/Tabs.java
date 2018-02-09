package GUI;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import constants.Tab;

public class Tabs {
	private JTabbedPane tabs;
	private JPanel[] panels = new JPanel[3];
	
	public Tabs() {
		this.tabs = new JTabbedPane();
		this.tabs.setPreferredSize(new Dimension(350,400));
		
		int i = 0;
		for(Tab tab : Tab.values()) {
			this.panels[i] = new JPanel();
			this.tabs.add(tab.toString().toLowerCase(), this.panels[i]);
			i++;
		}
	}
	
	public JTabbedPane getTabBar() {
		return this.tabs;
	}
}
