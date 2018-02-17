package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JColorChooser;

public class ColorChooserBtn extends JButton implements ActionListener{

	BufferedImage image;
	
	public ColorChooserBtn(BufferedImage image){
		super("choose Color");
		this.image = image;
		this.addActionListener(this);
		this.setMaximumSize(new Dimension(200,20));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Color tempColor = JColorChooser.showDialog(this, "Set color of Element.", new Color(this.image.getRGB(0, 0)));
		
		for(int y = 0; y < this.image.getHeight();y++) {
			for(int x = 0; x < this.image.getWidth();x++) {
				this.image.setRGB(x, y, tempColor.getRGB());
			}
		}
	}

}
