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
import javax.swing.JPanel;

import constants.ObjectType;
import core.Model;
import core.View;

public class ObjectExplorer extends JPanel implements ActionListener{
	private JFileChooser fileS = new JFileChooser();
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
	

	@Override
	public void actionPerformed(ActionEvent e) {
		int returnVal = this.fileS.showOpenDialog(this);
		
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File tempFile = this.fileS.getSelectedFile();
			BufferedImage tempImg;
			
			try {
				tempImg = ImageIO.read(new File(tempFile.getPath()));
				Element tempEle = new Element(ObjectType.ASSET,tempImg,this.view,this.model);
				tempEle.setText(tempFile.getName());
				this.objectContainer.add(tempEle);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
