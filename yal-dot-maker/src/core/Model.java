package core;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import GUI.InfoBar;
import GUI.Map;
import GUI.MenuBar;
import GUI.ObjectList;
import GUI.Tabs;

public class Model {
	private boolean highlightHitbox;
	private Map map;
	private MenuBar menu;
	private Tabs tabs;
	private ObjectList objectList;
	private JPanel west;
	private InfoBar infoBar;
	
	public Model() {
		this.menu = new MenuBar();
		this.west = new JPanel();
		this.tabs = new Tabs();
		this.objectList = new ObjectList();
		
		this.west.setLayout(new BorderLayout());
		this.west.add(this.tabs.getTabBar(),BorderLayout.NORTH);
		this.west.add(this.objectList.getObjectList(),BorderLayout.SOUTH);
		this.west.setBorder(LineBorder.createBlackLineBorder());
	}
	
	public boolean isHighlightHitbox() {
		return highlightHitbox;
	}
	public void setHighlightHitbox(boolean highlightHitbox) {
		this.highlightHitbox = highlightHitbox;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public MenuBar getMenu() {
		return menu;
	}
	public void setMenu(MenuBar menu) {
		this.menu = menu;
	}
	public Tabs getTabs() {
		return tabs;
	}
	public void setTabs(Tabs tabs) {
		this.tabs = tabs;
	}
	public ObjectList getObjectList() {
		return objectList;
	}
	public void setObjectList(ObjectList objectList) {
		this.objectList = objectList;
	}
	public InfoBar getInfoBar() {
		return infoBar;
	}
	public void setInfoBar(InfoBar infoBar) {
		this.infoBar = infoBar;
	}
	public JPanel getWest() {
		return this.west;
	}
	public void setWest(JPanel west) {
		this.west = west;
	}
}
