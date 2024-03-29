package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import core.Model;

/**
 * class for settings background image
 * @author bschab
 *
 */
public class BackgroundImageBtn extends JButton implements ActionListener{
	Model model;
	JFileChooser jfc = new JFileChooser();
	
	/**
	 * constructor
	 * @param model passes information about model
	 */
	public BackgroundImageBtn(Model model) {
		super("set background image");
		this.model = model;
		this.setMaximumSize(new Dimension(200,20));
		this.addActionListener(this);
	}
	
	/**
	 * implemented ActionListener function
	 * if button is pressed ask which picture should be used for
	 * the background
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int returnVal = this.jfc.showOpenDialog(this);
		
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File tempFile = this.jfc.getSelectedFile();
			
			try {
				BufferedImage tempImg = ImageIO.read(new File(tempFile.getPath()));
				if(tempImg != null)
					this.model.getMap().setBackgroundImage(tempImg);
				else
					JOptionPane.showMessageDialog(this, "An error occurred with loading the selected image.", "Error", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, "An error occurred with loading the selected image.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
