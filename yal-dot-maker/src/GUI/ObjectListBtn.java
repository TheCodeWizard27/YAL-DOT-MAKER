package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import constants.ObjectModes;
import core.Model;
import core.View;
import map.Asset;
import map.Deathbox;
import map.ElementTemplate;
import map.EndBox;
import map.Hitbox;

/**
 * class for the Buttons of the Object list
 * @author bschab
 *
 */
public class ObjectListBtn extends JButton implements ActionListener{
	private View view;
	private Model model;
	private ObjectModes type;
	
	/**
	 * constructor
	 * @param view passes GUI information
	 * @param model passes model information
	 * @param type passe button type
	 */
	public ObjectListBtn(View view, Model model, ObjectModes type) {
		super(type.toString().toLowerCase());
		this.view = view;
		this.model = model;
		this.type = type;
		this.addActionListener(this);
	}
	
	/**
	 * Implemented ActionListener function
	 * does whatever the chosen button does
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ElementTemplate object = this.model.getCurrentObj();
		Map map = this.model.getMap();
		
		if(object != null) {
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
					JOptionPane.showMessageDialog(this.view, "This object can't be copied.","Error", JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(this.view, "This object can't be deleted.","Error", JOptionPane.ERROR_MESSAGE);
				}
				this.view.getObjectList().getList().clearSelection();
				this.model.setCurrentObj(null);
				this.view.getTabs().addObjectSettings();
				break;
			case LAYER_UP:
				if(map.getAssets().contains(object)) {
					int layer = map.getAssets().indexOf(object);
					if(layer < map.getAssets().size()-1) {
						Asset tempAsset = (Asset) object;
						map.getAssets().remove(object);
						map.getAssets().add(++layer,tempAsset);
					}
				}else {
					JOptionPane.showMessageDialog(this.view, "This object does not support this feature.","Support of Object", JOptionPane.INFORMATION_MESSAGE);
				}
				
				break;
			case LAYER_DOWN:
				if(map.getAssets().contains(object)) {
					int layer = map.getAssets().indexOf(object);
					if(layer > 0) {
						Asset tempAsset = (Asset) object;
						map.getAssets().remove(object);
						map.getAssets().add(--layer,tempAsset);
					}
				}else {
					JOptionPane.showMessageDialog(this.view, "This object does not support this feature.","Support of Object", JOptionPane.INFORMATION_MESSAGE);
				}
				
				break;
			}
			this.view.getObjectList().update();
			this.view.getObjectList().getList().setSelectedValue(object.getName(), true);
		}else {
			JOptionPane.showMessageDialog(this.view, "No object selected!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
