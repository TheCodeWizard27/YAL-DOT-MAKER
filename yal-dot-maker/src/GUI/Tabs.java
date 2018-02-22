package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import constants.MapProperty;
import constants.ObjectProperty;
import core.Model;
import core.View;
import map.Asset;

/**
 * class for the tabs
 * @author bschab
 *
 */
public class Tabs{
	private Model model;
	private View view;
	private JTabbedPane tabs;
	private JPanel mapSettingsTab;
	private ObjectExplorer objectExplorerTab;
	private JPanel objectSettingsTab;
	
	/**
	 * constructor
	 * @param model passes model information
	 * @param view passes GUI information
	 */
	public Tabs(Model model, View view) {
		this.model = model;
		this.view = view;
		this.tabs = new JTabbedPane();
		this.tabs.setPreferredSize(new Dimension(350,400));
		
		this.addMapSettings();
		this.addObjectExplorer();
		this.addObjectSettings();
		
		this.tabs.add("Map Settings", this.mapSettingsTab);
		this.tabs.add("Object Explorer", this.objectExplorerTab);
		this.tabs.add("Object Settings", this.objectSettingsTab);
	}
	
	/**
	 * adds Map properties settings to tabs
	 */
	public void addMapSettings() {
		this.mapSettingsTab = new JPanel();
		this.mapSettingsTab.setLayout(new BorderLayout());
		this.mapSettingsTab.setBorder(new EmptyBorder(5,5,5,5));
		
		Box container = Box.createVerticalBox();
		
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
			tempContainer.setLayout(new BorderLayout());
			tempContainer.add(label,BorderLayout.WEST);
			tempContainer.add(new InputField(this.model.getMap(),property),BorderLayout.EAST);
			tempContainer.setMaximumSize(new Dimension(450,20));
			container.add(tempContainer);
		}
		
		ColorChooserBtn tempBtn = new ColorChooserBtn(this.model.getMap().getBackgroundImage());
		tempBtn.setText("set background color");
		
		container.add(new BackgroundImageBtn(this.model));
		container.add(tempBtn);
		
		this.mapSettingsTab.add(container, BorderLayout.WEST);
	}

	/**
	 * adds new ObjectExplorer to tabs
	 */
	public void addObjectExplorer() {
		this.objectExplorerTab = new ObjectExplorer(this.view, this.model);
	}
	
	/**
	 * adds ObjectSettings tab for current
	 * selected Object
	 */
	public void addObjectSettings() {
		if(this.objectSettingsTab != null)
			this.tabs.remove(this.objectSettingsTab);
		
		this.objectSettingsTab = new JPanel();
		this.objectSettingsTab.setLayout(new BorderLayout());
		this.objectSettingsTab.setBorder(new EmptyBorder(5,5,5,5));
		
		Box container = Box.createVerticalBox();
		
		if(this.model.getCurrentObj() != null) {
			
			for(ObjectProperty property : ObjectProperty.values()) {
				JPanel tempContainer = new JPanel();
				JLabel label = new JLabel();
				label.setText(property.toString().toLowerCase() + " : ");
				
				tempContainer.setLayout(new BorderLayout());
				tempContainer.setMaximumSize(new Dimension(450,20));
				tempContainer.add(label, BorderLayout.WEST);
				tempContainer.add(new SettingsInput(this.view, this.model,property),BorderLayout.EAST);
				container.add(tempContainer);
			}
			if(this.model.getCurrentObj() instanceof Asset) {
				Asset currObj = (Asset) this.model.getCurrentObj();
				container.add(new ColorChooserBtn(currObj.getSprite()));
			}
		}
		
		this.objectSettingsTab.add(container, BorderLayout.WEST);
		this.tabs.add("Object Settings",this.objectSettingsTab);

		if(this.tabs.getTabCount() > 2)
			this.tabs.setSelectedIndex(2);
		
		this.tabs.revalidate();
	}
	
	/**
	 * getters n' setters
	 * @return
	 */
	public JTabbedPane getTabBar() {
		return this.tabs;
	}
	public ObjectExplorer getExplorer() {
		return this.objectExplorerTab;
	}
}
