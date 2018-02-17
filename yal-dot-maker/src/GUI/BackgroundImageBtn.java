package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import core.Model;

public class BackgroundImageBtn extends JButton implements ActionListener{

	Model model;
	JFileChooser jfc = new JFileChooser();
	
	public BackgroundImageBtn(Model model) {
		super("set background image");
		this.model = model;
		this.setMaximumSize(new Dimension(200,20));
		this.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int returnVal = this.jfc.showOpenDialog(this);
		
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File tempFile = this.jfc.getSelectedFile();
			
			try {
				this.model.getMap().setBackgroundImage(ImageIO.read(new File(tempFile.getPath())));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
