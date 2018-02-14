package GUI;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import constants.MapProperty;
import core.Model;

public class Tabs {
	private JTabbedPane tabs;
	private JPanel mapSettingsTab;
	private JPanel objectExplorerTab;
	private JPanel objectSettingsTab;
	
	public Tabs(Model model) {
		this.tabs = new JTabbedPane();
		this.tabs.setPreferredSize(new Dimension(350,400));
		
		this.addMapSettings(model);
		this.addObjectExplorer();
		this.addObjectSettings();
		
		this.tabs.add("Map Settings", this.mapSettingsTab);
		this.tabs.add("Object Explorer", this.objectExplorerTab);
		this.tabs.add("Object Settings", this.objectSettingsTab);
	}
	
	public JTabbedPane getTabBar() {
		return this.tabs;
	}
	
	public void addMapSettings(Model model) {
		this.mapSettingsTab = new JPanel();
		
		for(MapProperty property : MapProperty.values()) {
			JPanel tempContainer = new JPanel();
			JLabel label = new JLabel();
			switch(property) {
			case NAME:
				label.setText("Map Name : ");
				break;
			case WIDTH:
				label.setText("Map width : ");
				break;
			case HEIGHT:
				label.setText("Map height : ");
				break;
			}
			tempContainer.add(label);
			tempContainer.add(new InputField(model.getMap(),property));
			this.mapSettingsTab.add(tempContainer);
		}
	}
	
	public void addObjectExplorer() {
		this.objectExplorerTab = new JPanel();
	}
	
	public void addObjectSettings() {
		this.objectSettingsTab = new JPanel();
	}
}
