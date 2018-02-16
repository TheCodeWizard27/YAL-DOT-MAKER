package GUI;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import constants.MapProperty;
import constants.ObjectProperty;
import core.Model;
import core.View;

public class Tabs{
	private Model model;
	private View view;
	private JTabbedPane tabs;
	private JPanel mapSettingsTab;
	private ObjectExplorer objectExplorerTab;
	private JPanel objectSettingsTab;
	
	public Tabs(Model model, View view) {
		this.model = model;
		this.view = view;
		this.tabs = new JTabbedPane();
		this.tabs.setPreferredSize(new Dimension(350,400));
		
		this.addMapSettings(model);
		this.addObjectExplorer(view, model);
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

	
	public void addObjectExplorer(View view, Model model) {
		this.objectExplorerTab = new ObjectExplorer(view, model);
		
	}
	
	public void addObjectSettings() {
		this.tabs.remove(this.objectSettingsTab);
		this.objectSettingsTab = new JPanel();
		
		if(this.model.getCurrentObj() != null) {
			for(ObjectProperty property : ObjectProperty.values()) {
				JPanel tempContainer = new JPanel();
				JLabel label = new JLabel();
				label.setText(property.toString().toLowerCase() + " : ");
				
				tempContainer.add(label);
				tempContainer.add(new SettingsInput(this.view, this.model,property));
				this.objectSettingsTab.add(tempContainer);
			}
		}
		
		this.tabs.add("Object Settings",this.objectSettingsTab);

		if(this.tabs.getTabCount() > 2)
			this.tabs.setSelectedIndex(2);
		
		this.tabs.revalidate();
	}
}
