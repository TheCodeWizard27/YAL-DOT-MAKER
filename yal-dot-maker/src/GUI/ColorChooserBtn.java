package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JColorChooser;

/**
 * class for choosing the color of a certain image
 * @author bschab
 *
 */
public class ColorChooserBtn extends JButton implements ActionListener{
	BufferedImage image;
	
	/**
	 * constructor
	 * @param image passes the pointer to the image
	 */
	public ColorChooserBtn(BufferedImage image){
		super("choose Color");
		this.image = image;
		this.addActionListener(this);
		this.setMaximumSize(new Dimension(200,20));
	}
	
	/**
	 * implements function of action listener
	 * which changes color of image
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Color tempColor = JColorChooser.showDialog(this, "Set color of Element.", new Color(this.image.getRGB(0, 0)));
		
		if(tempColor != null) {
			for(int y = 0; y < this.image.getHeight();y++) {
				for(int x = 0; x < this.image.getWidth();x++) {
					this.image.setRGB(x, y, tempColor.getRGB());
				}
			}
		}
	}

}
