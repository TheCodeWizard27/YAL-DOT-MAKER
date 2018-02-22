package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import constants.ObjectType;
import core.Model;
import core.View;

public class ObjectExplorer extends JPanel implements ActionListener{
	private JFileChooser jfc = new JFileChooser();
	private JButton newBtn = new JButton("import asset");
	private JPanel objectContainer = new JPanel();
	private View view;
	private Model model;
	
	public ObjectExplorer(View view, Model model) {
		super();
		this.view = view;
		this.model = model;
		this.setLayout(new BorderLayout());
		this.objectContainer.setLayout(new BoxLayout(this.objectContainer, BoxLayout.Y_AXIS));
		
		for(ObjectType type : ObjectType.values()) {
			Element element = new Element(type, null, view , model);
			this.objectContainer.add(element);
		}
		this.newBtn.addActionListener(this);
		this.add(objectContainer, BorderLayout.CENTER);
		this.add(newBtn, BorderLayout.SOUTH);
	}
	

	public void addElement(File image) {
		File tempFile = image;
		BufferedImage tempImg;
		
		try {
			tempImg = ImageIO.read(new File(tempFile.getPath()));
			Element tempEle = new Element(ObjectType.ASSET,tempImg,this.view,this.model);
			tempEle.setText(tempFile.getName());
			this.objectContainer.add(tempEle);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(this.view, "An error occured with importing this asset.","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int returnVal = this.jfc.showOpenDialog(this);
		
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			this.addElement(this.jfc.getSelectedFile());
		}
	}
}
