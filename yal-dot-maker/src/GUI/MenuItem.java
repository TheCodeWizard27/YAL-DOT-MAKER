package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import constants.Menu;
import core.Model;
import core.View;
import map.Asset;
import map.Deathbox;
import map.EndBox;
import map.Hitbox;

public class MenuItem extends JMenuItem implements ActionListener{
	private Menu type;
	private Model model;
	private View view;
	private JFileChooser jfc = new JFileChooser();
	
	public MenuItem(Menu type, Model model,View view) {
		super(type.toString().toLowerCase());
		this.addActionListener(this);
		this.jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		this.type = type;
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(this.type) {
		case SAVE:
			int returnVal = this.jfc.showSaveDialog(this);
			
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				
				File tempDir = this.jfc.getSelectedFile();
				Map map = this.model.getMap();
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder;
				try {
					dBuilder = dbFactory.newDocumentBuilder();
					Document file = dBuilder.newDocument();
					Element container = file.createElement("map-data");
					
					HashMap<String, BufferedImage> tempImages = new HashMap<String,BufferedImage>();
					
					//adding map information
					Element mapEle = file.createElement("map");
					Element mapName = file.createElement("name");
					Element mapWidth = file.createElement("width");
					Element mapHeight = file.createElement("height");
					Element mapBackground = file.createElement("backgroundImg");
					mapBackground.setAttribute("src", "bgImage");
					
					tempImages.put("bgImage.png", map.getBackgroundImage());
					
					mapName.appendChild(file.createTextNode(map.getName()));
					mapWidth.appendChild(file.createTextNode(String.valueOf(map.getSize().getX())));
					mapHeight.appendChild(file.createTextNode(String.valueOf(map.getSize().getY())));
					
					mapEle.appendChild(mapName);
					mapEle.appendChild(mapWidth);
					mapEle.appendChild(mapHeight);
					mapEle.appendChild(mapBackground);
					
					container.appendChild(mapEle);
					
					//adding player information
					Element playerEle = file.createElement("player");
					Element playerPosX = file.createElement("posX");
					Element playerPosY = file.createElement("posY");
					Element playerWidth = file.createElement("width");
					Element playerHeight = file.createElement("height");
					
					playerPosX.appendChild(file.createTextNode(String.valueOf(map.getPlayer().getPos().getX())));
					playerPosY.appendChild(file.createTextNode(String.valueOf(map.getPlayer().getPos().getY())));
					playerWidth.appendChild(file.createTextNode(String.valueOf(map.getPlayer().getSize().getX())));
					playerHeight.appendChild(file.createTextNode(String.valueOf(map.getPlayer().getSize().getY())));
					
					playerEle.appendChild(playerPosX);
					playerEle.appendChild(playerPosY);
					playerEle.appendChild(playerWidth);
					playerEle.appendChild(playerHeight);
					
					container.appendChild(playerEle);
					
					//adding camera information
					Element cameraEle = file.createElement("camera");
					Element cameraPosX = file.createElement("posX");
					Element cameraPosY = file.createElement("posY");
					Element cameraWidth = file.createElement("width");
					Element cameraHeight = file.createElement("height");
					
					cameraPosX.appendChild(file.createTextNode(String.valueOf(map.getCamera().getPos().getX())));
					cameraPosY.appendChild(file.createTextNode(String.valueOf(map.getCamera().getPos().getY())));
					cameraWidth.appendChild(file.createTextNode(String.valueOf(map.getCamera().getSize().getX())));
					cameraHeight.appendChild(file.createTextNode(String.valueOf(map.getCamera().getSize().getY())));
					
					cameraEle.appendChild(cameraPosX);
					cameraEle.appendChild(cameraPosY);
					cameraEle.appendChild(cameraWidth);
					cameraEle.appendChild(cameraHeight);
					
					container.appendChild(cameraEle);
					
					for(Hitbox hitbox : map.getHitboxes()) {
						Element hitboxEle = file.createElement("hitbox");
						Element hitboxPosX = file.createElement("posX");
						Element hitboxPosY = file.createElement("posY");
						Element hitboxWidth = file.createElement("width");
						Element hitboxHeight = file.createElement("height");
						hitboxEle.setAttribute("name", hitbox.getName());
						
						hitboxPosX.appendChild(file.createTextNode(String.valueOf(hitbox.getPos().getX())));
						hitboxPosY.appendChild(file.createTextNode(String.valueOf(hitbox.getPos().getY())));
						hitboxWidth.appendChild(file.createTextNode(String.valueOf(hitbox.getSize().getX())));
						hitboxHeight.appendChild(file.createTextNode(String.valueOf(hitbox.getSize().getY())));
						
						hitboxEle.appendChild(hitboxPosX);
						hitboxEle.appendChild(hitboxPosY);
						hitboxEle.appendChild(hitboxWidth);
						hitboxEle.appendChild(hitboxHeight);
						
						container.appendChild(hitboxEle);
					}
					
					for(EndBox endbox : map.getEndBox()) {
						Element endboxEle = file.createElement("endbox");
						Element endboxPosX = file.createElement("posX");
						Element endboxPosY = file.createElement("posY");
						Element endboxWidth = file.createElement("width");
						Element endboxHeight = file.createElement("height");
						endboxEle.setAttribute("name", endbox.getName());
						
						endboxPosX.appendChild(file.createTextNode(String.valueOf(endbox.getPos().getX())));
						endboxPosY.appendChild(file.createTextNode(String.valueOf(endbox.getPos().getY())));
						endboxWidth.appendChild(file.createTextNode(String.valueOf(endbox.getSize().getX())));
						endboxHeight.appendChild(file.createTextNode(String.valueOf(endbox.getSize().getY())));
						
						endboxEle.appendChild(endboxPosX);
						endboxEle.appendChild(endboxPosY);
						endboxEle.appendChild(endboxWidth);
						endboxEle.appendChild(endboxHeight);
						
						container.appendChild(endboxEle);
					}
					
					for(Deathbox deathbox : map.getDeathboxes()) {
						Element deathboxEle = file.createElement("deathbox");
						Element deathboxPosX = file.createElement("posX");
						Element deathboxPosY = file.createElement("posY");
						Element deathboxWidth = file.createElement("width");
						Element deathboxHeight = file.createElement("height");
						deathboxEle.setAttribute("name", deathbox.getName());
						
						deathboxPosX.appendChild(file.createTextNode(String.valueOf(deathbox.getPos().getX())));
						deathboxPosY.appendChild(file.createTextNode(String.valueOf(deathbox.getPos().getY())));
						deathboxWidth.appendChild(file.createTextNode(String.valueOf(deathbox.getSize().getX())));
						deathboxHeight.appendChild(file.createTextNode(String.valueOf(deathbox.getSize().getY())));
						
						deathboxEle.appendChild(deathboxPosX);
						deathboxEle.appendChild(deathboxPosY);
						deathboxEle.appendChild(deathboxWidth);
						deathboxEle.appendChild(deathboxHeight);
						
						container.appendChild(deathboxEle);
					}
					
					for(Asset asset : map.getAssets()) {
						Element assetEle = file.createElement("asset");
						Element assetPosX = file.createElement("posX");
						Element assetPosY = file.createElement("posY");
						Element assetWidth = file.createElement("width");
						Element assetHeight = file.createElement("height");
						assetEle.setAttribute("name", asset.getName());
						
						if(asset.getSpriteName() != null) {
							assetEle.setAttribute("src",asset.getSpriteName());
							if(!tempImages.containsKey(asset.getSpriteName()))
								tempImages.put(asset.getSpriteName(),asset.getSprite());
						}else {
							assetEle.setAttribute("color",String.valueOf(asset.getSprite().getRGB(0,0)));
						}
						
						assetPosX.appendChild(file.createTextNode(String.valueOf(asset.getPos().getX())));
						assetPosY.appendChild(file.createTextNode(String.valueOf(asset.getPos().getY())));
						assetWidth.appendChild(file.createTextNode(String.valueOf(asset.getSize().getX())));
						assetHeight.appendChild(file.createTextNode(String.valueOf(asset.getSize().getY())));
						
						assetEle.appendChild(assetPosX);
						assetEle.appendChild(assetPosY);
						assetEle.appendChild(assetWidth);
						assetEle.appendChild(assetHeight);
						
						container.appendChild(assetEle);
					}
					
					file.appendChild(container);
					
					Transformer transformer = TransformerFactory.newInstance().newTransformer();
					new File(tempDir.getAbsolutePath() + "\\" + map.getName()).mkdirs();
					Result output = new StreamResult(new File(tempDir.getAbsolutePath() + "\\" + map.getName() + "\\mapData.xml"));
					Source input = new DOMSource(file);
					
					transformer.transform(input, output);
					
					for(Entry<String,BufferedImage> entry : tempImages.entrySet()) {
						ImageIO.write(entry.getValue(), "png", new File(tempDir.getAbsolutePath() + "\\" + map.getName() + "\\" + entry.getKey()));
					}
					
				}catch(Exception except) {
					except.printStackTrace();
				}
			}
			break;
		case NEW:
			this.model.setMap(new Map());
			this.model.setCurrentObj(null);
			this.model.setZoom(100);
			this.view.resetGUI();
			
			break;
		case LOAD:
			int loadVal = this.jfc.showOpenDialog(this);
			Map map = this.model.getMap();
			
			if(loadVal == JFileChooser.APPROVE_OPTION) {
				try {
					this.model.setMap(new Map());
					this.model.setCurrentObj(null);
					this.model.setZoom(100);
					
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document file = dBuilder.parse(new File(this.jfc.getSelectedFile().getAbsolutePath() + "\\mapData.xml"));
					file.getDocumentElement().normalize();
					
					//getting map data
					Element mapEle = (Element) file.getElementsByTagName("map").item(0);
					map.setName(mapEle.getElementsByTagName("name").item(0).getTextContent());
					
					this.view.resetGUI();
				} catch (ParserConfigurationException | SAXException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			break;
		}
	}
}
