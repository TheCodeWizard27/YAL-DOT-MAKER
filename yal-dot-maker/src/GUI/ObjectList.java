package GUI;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import constants.ObjectModes;

public class ObjectList {
	private JPanel container;
	private JList objectsList;
	private DefaultListModel list;
	private JPanel btnContainer;
	private ObjectListBtn[] buttons = new ObjectListBtn[4];
	
	public ObjectList(){
		this.container = new JPanel();
		this.btnContainer = new JPanel();
		this.objectsList = new JList();
		this.objectsList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.objectsList.setLayoutOrientation(JList.HORIZONTAL_WRAP);

		this.list = new DefaultListModel();
		this.list.addElement("camera");
		this.list.addElement("background");
		this.list.addElement("nstuff");
		
		this.objectsList.setModel(this.list);
		
		int i = 0;
		for(ObjectModes mode : ObjectModes.values()) {
			this.buttons[i] = new ObjectListBtn(mode);
			this.btnContainer.add(this.buttons[i]);
			i++;
		}
		
		this.container.add(this.objectsList);
		this.container.add(this.btnContainer);
		this.container.setBorder(LineBorder.createBlackLineBorder());
	}
	
	public JPanel getObjectList() {
		return this.container;
	}
}
