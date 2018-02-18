package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import constants.ObjectModes;
import core.Model;
import core.View;
import map.Asset;
import map.Deathbox;
import map.EndBox;
import map.Hitbox;

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
				Deathbox deathbox = new Deathbox((Deathbox) object);
				deathbox.setName(deathbox.getName() + "(copy)");
				map.getDeathboxes().add(deathbox);
			}else if(map.getHitboxes().contains(object)) {
				Hitbox hitbox = new Hitbox((Hitbox) object);
				hitbox.setName(hitbox.getName() + "(copy)");
				map.getHitboxes().add(hitbox);
			}else if(map.getEndBox().contains(object)){
				EndBox endbox = new EndBox((EndBox) object);
				endbox.setName(endbox.getName() + "(copy)");
				map.getEndBox().add(endbox);
			}else {
				
			}
			
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
			this.view.getObjectList().getList().clearSelection();
			this.model.setCurrentObj(null);
			this.view.getTabs().addObjectSettings();
			break;
		}
		
		this.view.getObjectList().update();
	}
}
