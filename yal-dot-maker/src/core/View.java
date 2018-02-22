package core;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import GUI.InfoBar;
import GUI.MenuBar;
import GUI.ObjectList;
import GUI.Tabs;
import graphics.Canvas;

/**
 * View class holds all GUI elements that are shown
 * @author bschab
 *
 */
public class View extends JFrame {
	private static View view;
	private Model model;
	private MenuBar menu;
	private Tabs tabs;
	private ObjectList objectList;
	private JSplitPane west;
	private InfoBar infoBar;
	private Canvas canvas;
	private JPanel container;

	/**
	 * constructor of view which is private
	 * for singleton
	 * 
	 * @param model of the controller
	 */
	private View(Model model) {
		super("YAL DOT MAKER");
		this.tabs = new Tabs(model, this);
		this.objectList = new ObjectList(model, this);
		this.west = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.tabs.getTabBar(), this.objectList.getObjectList());
		this.infoBar = new InfoBar();
		this.canvas = new Canvas(model, this);
		this.menu = new MenuBar(model, this);
		this.model = model;
		this.container = new JPanel();

		this.setSize(1200, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(this.menu.getMenuBar());

		this.container.setLayout(new BorderLayout());
		this.container.add(this.infoBar.getInfoBar(), BorderLayout.SOUTH);
		this.container.add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.west, this.canvas.getCanvas()),
				BorderLayout.CENTER);

		this.west.setDividerLocation(520);
		this.add(this.container);
		this.setVisible(true);
	}

	
	/**
	 * updates GUI if for example map is loaded or created anew
	 */
	public void resetGUI() {

		this.getContentPane().removeAll();
		this.tabs = new Tabs(this.model, this);
		this.objectList = new ObjectList(model, this);
		this.west = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.tabs.getTabBar(), this.objectList.getObjectList());
		this.infoBar = new InfoBar();
		this.menu = new MenuBar(this.model, this);
		this.container = new JPanel();

		this.setJMenuBar(this.menu.getMenuBar());

		this.container.setLayout(new BorderLayout());
		this.container.add(this.infoBar.getInfoBar(), BorderLayout.SOUTH);
		this.container.add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.west, this.canvas.getCanvas()),
				BorderLayout.CENTER);

		this.west.setDividerLocation(520);
		this.add(this.container);

		this.objectList.update();
		this.revalidate();
		this.setVisible(true);
	}

	/**
	 * singleton constructor 
	 * 
	 * @param model
	 * @return returns only once created view object
	 */
	public static View getInstance(Model model) {
		if (View.view == null) {
			View.view = new View(model);
		}

		return View.view;
	}

	/**
	 * getters n' setters
	 * @return
	 */
	public ObjectList getObjectList() {
		return objectList;
	}
	public void setObjectList(ObjectList objectList) {
		this.objectList = objectList;
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
	public Tabs getTabs() {
		return tabs;
	}
	public void setTabs(Tabs tabs) {
		this.tabs = tabs;
	}
}
