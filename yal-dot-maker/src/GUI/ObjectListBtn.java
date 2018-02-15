package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import constants.ObjectModes;
import core.Model;
import core.View;
import map.Asset;
import map.Deathbox;

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
			if(map.getAssets().contains(object)) {
				Asset asset = new Asset((Asset)object);
				asset.setName(asset.getName() + "(copy)");
				map.getAssets().add(asset);
			}else if(map.getDeathboxes().contains(object)) {
				map.getDeathboxes().remove(object);
				Deathbox deathbox = new Deathbox((Deathbox)object);
				deathbox.setName(deathbox.getName() + "(copy)");
			}else if(map.getHitboxes().contains(object)) {
				map.getHitboxes().remove(object);
				Asset asset = new Asset((Asset)object);
				asset.setName(asset.getName() + "(copy)");
			}else if(map.getEndBox().contains(object)){
				map.getEndBox().remove(object);
				Asset asset = new Asset((Asset)object);
				asset.setName(asset.getName() + "(copy)");
			}else {
				
			}
			
			this.view.getObjectList().update();
			
			break;
		case DELETE:
			if(map.getAssets().contains(object)) {
				map.getAssets().remove(object);
			}else if(map.getDeathboxes().contains(object)) {
				map.getDeathboxes().remove(object);
			}else if(map.getHitboxes().contains(object)) {
				map.getHitboxes().remove(object);
			}else if(map.getEndBox().contains(object)){
				map.getEndBox().remove(object);
			}else {
				
			}
			
			this.view.getObjectList().update();
			
			break;
		}
		
		this.view.getObjectList().update();
	}
}
