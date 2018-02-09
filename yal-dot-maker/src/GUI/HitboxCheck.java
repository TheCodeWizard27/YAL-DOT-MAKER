package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import core.Model;

public class HitboxCheck extends JCheckBox implements ActionListener{
	
	private Model model;
	
	public HitboxCheck(Model model) {
		super();
		this.model = model;
		this.addActionListener(this);
	}
	
	/**
	 * Changes if hitboxes should be shown
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.model.isHighlightHitbox()) {
			this.model.setHighlightHitbox(false);
		}else {
			this.model.setHighlightHitbox(true);
		}
		System.out.println(this.model.isHighlightHitbox());
	}
}
