package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class InfoBar {
	private JPanel container;
	private JLabel pos;
	private JLabel currObj;
	private JLabel zoom;
	
	public InfoBar() {
		this.container = new JPanel();
		this.pos = new JLabel("current X / Y :      ");
		this.currObj = new JLabel("current object :      ");
		this.zoom = new JLabel("Zoom : 100%");
		
		this.container.setLayout(new BorderLayout());
		this.container.add(pos, BorderLayout.WEST);
		this.container.add(currObj, BorderLayout.CENTER);
		this.container.add(zoom, BorderLayout.EAST);
		this.container.setBorder(new BevelBorder(BevelBorder.LOWERED));
	}
	
	public JPanel getInfoBar() {
		return this.container;
	}
}
