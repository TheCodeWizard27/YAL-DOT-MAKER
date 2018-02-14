package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import constants.ObjectModes;
import core.Model;
import core.View;
import map.Asset;
import map.Camera;
import map.Player;

public class ObjectListBtn extends JButton implements ActionListener{
	private View view;
	private Model model;
	private ObjectModes type;
	
	public ObjectListBtn(View view, Model model, ObjectModes type) {
		super(type.toString().toLowerCase());
		this.view = view;
		this.model = model;
		this.type = type;
		this.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = this.model.getCurrentObj();
		Map map = this.model.getMap();
		
		switch(this.type) {
		case COPY:
			break;
		case DELETE:
			if(map.getAssets().contains(object)) {
				map.getAssets().remove(object);
			}else if(map.getDeathboxes().contains(object)) {
				map.getDeathboxes().remove(object);
			}else if(map.getHitboxes().contains(object)) {
				map.getHitboxes().contains(object);
			}else {
				//print out failure
			}
			break;
		}
		
		this.view.getObjectList().update();
	}
}
