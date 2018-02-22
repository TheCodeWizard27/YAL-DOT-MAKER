package GUI;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import constants.ObjectModes;
import core.Model;
import core.View;
import map.Asset;
import map.Deathbox;
import map.ElementTemplate;
import map.EndBox;
import map.Hitbox;

/**
 * class for the object list
 * @author bschab
 *
 */
public class ObjectList implements ListSelectionListener{
	private Model model;
	private View view;
	
	private JPanel container;
	private JList objectsList;
	private DefaultListModel list;
	private JPanel btnContainer;
	private JScrollPane scrollPane;
	private ObjectListBtn[] buttons = new ObjectListBtn[4];
	
	private HashMap<String, ElementTemplate> objects = new HashMap<String,ElementTemplate>();
	
	/**
	 * constructor
	 * @param model passes model information
	 * @param view passes GUI information
	 */
	public ObjectList(Model model, View view){
		this.model = model;
		this.view = view;
		this.container = new JPanel();
		this.btnContainer = new JPanel();
		
		this.objectsList = new JList();
		this.objectsList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.objectsList.setLayoutOrientation(JList.VERTICAL);
		
		this.list = new DefaultListModel();
		this.objectsList.setModel(this.list);
		
		int i = 0;
		for(ObjectModes mode : ObjectModes.values()) {
			this.buttons[i] = new ObjectListBtn(view, model, mode);
			this.btnContainer.add(this.buttons[i]);
			i++;
		}
		
		this.scrollPane = new JScrollPane(this.objectsList);
		this.container.setLayout(new BorderLayout());
		this.container.add(this.scrollPane,BorderLayout.NORTH);
		this.container.add(this.btnContainer,BorderLayout.SOUTH);
		this.container.setBorder(LineBorder.createBlackLineBorder());
		this.objectsList.addListSelectionListener(this);
	}
	
	/**
	 * updates object list if new object has been added
	 */
	public void update() {
		Map map = this.model.getMap();
	
		this.objects.clear();
		
		this.objects.put("Camera", map.getCamera());
		this.objects.put("Player", map.getPlayer());
		
		for(EndBox endbox : map.getEndBox()) {
			this.objects.put(endbox.getName(), endbox);
		}
		
		for(Hitbox hitbox : map.getHitboxes()) {
			this.objects.put(hitbox.getName(), hitbox);
		}
		
		for(Deathbox deathbox : map.getDeathboxes()) {
			this.objects.put(deathbox.getName(), deathbox);
		}
		
		for(Asset asset : map.getAssets()) {
			this.objects.put(asset.getName(), asset);
		}
		
		this.list.clear();
		for(Entry<String,ElementTemplate> list : this.objects.entrySet()) {
			this.list.addElement(list.getKey());
		}
	}
	
	/**
	 * Implemented function of valueChangeListener
	 * updates Object Settings tab
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		this.view.getTabs().addObjectSettings();
	}
	
	/**
	 * getters n' setters
	 * @return
	 */
	public JPanel getObjectList() {
		return this.container;
	}
	public JList getList() {
		return this.objectsList;
	}
	public HashMap<String, ElementTemplate> getObjects(){
		return this.objects;
	}
}
