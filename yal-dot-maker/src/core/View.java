package core;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import GUI.InfoBar;
import GUI.MenuBar;
import GUI.ObjectList;
import GUI.Tabs;
import graphics.Canvas;

public class View extends JFrame{
	private static View view;
	private Model model;
	private MenuBar menu;
	private Tabs tabs;
	private ObjectList objectList;
	private JSplitPane west;
	private InfoBar infoBar;
	private Canvas canvas;
	
	private View(Model model) {
		super("YAL DOT MAKER");
		this.tabs = new Tabs();
		this.objectList = new ObjectList();
		this.west = new JSplitPane(JSplitPane.VERTICAL_SPLIT,this.tabs.getTabBar(),this.objectList.getObjectList());
		this.canvas = new Canvas(model);
		this.menu = new MenuBar(model);
		this.model = model;
		
		this.setSize(1200,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(this.menu.getMenuBar());
		
		this.west.setDividerLocation(540);
		this.add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,this.west,this.canvas));
		this.setVisible(true);
	}
	
	public static View getInstance(Model model) {
		if(View.view == null) {
			View.view = new View(model);
		}
		
		return View.view;
	}
	
	public Canvas getCanvas() {
		return this.canvas;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public MenuBar getMenu() {
		return menu;
	}

	public void setMenu(MenuBar menu) {
		this.menu = menu;
	}

	public InfoBar getInfoBar() {
		return infoBar;
	}

	public void setInfoBar(InfoBar infoBar) {
		this.infoBar = infoBar;
	}
}
