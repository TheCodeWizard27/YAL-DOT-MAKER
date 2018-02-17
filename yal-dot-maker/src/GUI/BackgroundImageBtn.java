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

public class BackgroundImageBtn extends JButton implements ActionListener{

	BufferedImage image;
	JFileChooser jfc = new JFileChooser();
	
	public BackgroundImageBtn(BufferedImage image) {
		super("background image");
		this.setMaximumSize(new Dimension(200,20));
		this.addActionListener(this);
		this.image = image;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int returnVal = this.jfc.showOpenDialog(this);
		
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File tempFile = this.jfc.getSelectedFile();
			
			try {
				this.image = ImageIO.read(new File(tempFile.getPath()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
