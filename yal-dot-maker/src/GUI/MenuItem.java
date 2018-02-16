package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import constants.Menu;
import core.Model;

public class MenuItem extends JMenuItem implements ActionListener{
	private Menu type;
	private Model model;
	
	public MenuItem(Menu type, Model model) {
		super(type.toString().toLowerCase());
		this.addActionListener(this);
		this.type = type;
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(this.type) {
		case SAVE:
			Map map = this.model.getMap();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			try {
				dBuilder = dbFactory.newDocumentBuilder();
				Document file = dBuilder.newDocument();
				
				//adding map information
				Element mapEle = file.createElement("map");
				Element mapName = file.createElement("name");
				Element mapWidth = file.createElement("width");
				Element mapHeight = file.createElement("height");
				
				mapName.appendChild(file.createTextNode(map.getName()));
				mapWidth.appendChild(file.createTextNode(String.valueOf(map.getSize().getX())));
				mapHeight.appendChild(file.createTextNode(String.valueOf(map.getSize().getY())));
				
				mapEle.appendChild(mapName);
				mapEle.appendChild(mapWidth);
				mapEle.appendChild(mapHeight);
				
				file.appendChild(mapEle);
				
				
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				new File(map.getName()).mkdirs();
				Result output = new StreamResult(new File(map.getName() + "/output.xml"));
				Source input = new DOMSource(file);
				
				transformer.transform(input, output);
				
			}catch(Exception except) {
				except.printStackTrace();
			}
			break;
		}
	}
}
