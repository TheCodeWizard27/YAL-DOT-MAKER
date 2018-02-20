package titlescreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import core.Model;
import graphics.Vector2f;
import map.Asset;
import map.Camera;
import map.Hitbox;
import map.Player;
import mode.GameOption;
import mode.Map;
import mode.Mode;

public class TitleButton extends JButton implements ActionListener{
	private GameOption type;
	private Model model;
	private JList list;
	
	public TitleButton(GameOption type, Model model, JList list) {
		super();
		this.model = model;
		this.type = type;
		this.list = list;
		this.addActionListener(this);
		this.setFocusable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(this.type) {
		case START:
			if(!this.list.isSelectionEmpty()) {
				this.model.setMode(Mode.IN_GAME);
				
				try {				
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document file = dBuilder.parse(new File("src/maps/" + this.list.getSelectedValue() + "/mapData.xml"));
					file.getDocumentElement().normalize();
					
					Map map = new Map();
					
					//map info
					Element mapEle = (Element) file.getElementsByTagName("map").item(0);
					Hitbox bounds = new Hitbox(0,0,Float.parseFloat(mapEle.getElementsByTagName("width").item(0).getTextContent())
												,Float.parseFloat(mapEle.getElementsByTagName("height").item(0).getTextContent()));
					BufferedImage backgroundImage = ImageIO.read(new File("src/maps/" + this.list.getSelectedValue() + "/bgImage.png"));
					
					map.setBackgroundImg(backgroundImage);
					map.setBounds(bounds);
					
					//adding player
					Element playerEle = (Element) file.getElementsByTagName("player").item(0);
					Vector2f startPos = new Vector2f(Float.parseFloat(playerEle.getElementsByTagName("posX").item(0).getTextContent()),
													 Float.parseFloat(playerEle.getElementsByTagName("posY").item(0).getTextContent()));
					Vector2f playerSize = new Vector2f(Float.parseFloat(playerEle.getElementsByTagName("width").item(0).getTextContent()),
													   Float.parseFloat(playerEle.getElementsByTagName("height").item(0).getTextContent()));
					Player player = new Player(startPos,playerSize);
					map.setPlayer(player);
					map.setStartPos(startPos);
					
					//adding camera
					Element cameraEle = (Element) file.getElementsByTagName("camera").item(0);
					Vector2f cameraPos = new Vector2f(Float.parseFloat(cameraEle.getElementsByTagName("posX").item(0).getTextContent()),
							 						  Float.parseFloat(cameraEle.getElementsByTagName("posY").item(0).getTextContent()));
					Vector2f cameraSize = new Vector2f(Float.parseFloat(cameraEle.getElementsByTagName("width").item(0).getTextContent()),
													   Float.parseFloat(cameraEle.getElementsByTagName("height").item(0).getTextContent()));
					Camera camera = new Camera(cameraPos,cameraSize);
					map.setCamera(camera);
					
					//getting map elements
					NodeList hitboxNode = file.getElementsByTagName("hitbox");
					Hitbox[] hitboxList = new Hitbox[hitboxNode.getLength()];

					for(int i = 0; i < hitboxNode.getLength();i++) {
						Element hitboxEle = (Element) hitboxNode.item(i);
						Vector2f hitboxPos = new Vector2f(Float.parseFloat(hitboxEle.getElementsByTagName("posX").item(0).getTextContent()),
								 						  Float.parseFloat(hitboxEle.getElementsByTagName("posY").item(0).getTextContent()));
						Vector2f hitboxSize = new Vector2f(Float.parseFloat(hitboxEle.getElementsByTagName("width").item(0).getTextContent()),
														   Float.parseFloat(hitboxEle.getElementsByTagName("height").item(0).getTextContent()));
						hitboxList[i] = new Hitbox(hitboxPos,hitboxSize);
					}
					
					map.setHitboxes(hitboxList);
					
					NodeList endboxNode = file.getElementsByTagName("endbox");
					Hitbox[] endboxList = new Hitbox[endboxNode.getLength()];

					for(int i = 0; i < endboxNode.getLength();i++) {
						Element endboxEle = (Element) endboxNode.item(i);
						Vector2f endboxPos = new Vector2f(Float.parseFloat(endboxEle.getElementsByTagName("posX").item(0).getTextContent()),
								 						  Float.parseFloat(endboxEle.getElementsByTagName("posY").item(0).getTextContent()));
						Vector2f endboxSize = new Vector2f(Float.parseFloat(endboxEle.getElementsByTagName("width").item(0).getTextContent()),
														   Float.parseFloat(endboxEle.getElementsByTagName("height").item(0).getTextContent()));
						endboxList[i] = new Hitbox(endboxPos,endboxSize);
					}
					
					map.setGoalboxes(endboxList);
					
					NodeList deathboxNode = file.getElementsByTagName("deathbox");
					Hitbox[] deathboxList = new Hitbox[deathboxNode.getLength()];
					
					for(int i = 0; i < deathboxNode.getLength();i++) {
						Element deathboxEle = (Element) deathboxNode.item(i);
						Vector2f deathboxPos = new Vector2f(Float.parseFloat(deathboxEle.getElementsByTagName("posX").item(0).getTextContent()),
								 						  Float.parseFloat(deathboxEle.getElementsByTagName("posY").item(0).getTextContent()));
						Vector2f deathboxSize = new Vector2f(Float.parseFloat(deathboxEle.getElementsByTagName("width").item(0).getTextContent()),
														   Float.parseFloat(deathboxEle.getElementsByTagName("height").item(0).getTextContent()));
						deathboxList[i] = new Hitbox(deathboxPos,deathboxSize);
					}
					
					map.setDeathboxes(deathboxList);
					
					NodeList assetNode = file.getElementsByTagName("asset");
					Asset[] assetList = new Asset[assetNode.getLength()];
					
					for(int i = 0; i < assetNode.getLength();i++) {
						Element assetEle = (Element) assetNode.item(i);
						
						Vector2f assetPos = new Vector2f(Float.parseFloat(assetEle.getElementsByTagName("posX").item(0).getTextContent()),
															Float.parseFloat(assetEle.getElementsByTagName("posY").item(0).getTextContent()));
						Vector2f assetSize = new Vector2f(Float.parseFloat(assetEle.getElementsByTagName("width").item(0).getTextContent()),
															Float.parseFloat(assetEle.getElementsByTagName("height").item(0).getTextContent()));
						
						BufferedImage tempImg;
						
						if(assetEle.hasAttribute("src"))
							tempImg = ImageIO.read(new File("src/maps/" + this.list.getSelectedValue() + "/" + assetEle.getAttribute("src")));
						else {
							tempImg = new BufferedImage((int)assetSize.getX(),(int)assetSize.getY(),BufferedImage.TYPE_INT_ARGB);
							for(int y = 0; y < assetSize.getY();y++) {
								for(int x = 0; x < assetSize.getX();x++){
									tempImg.setRGB(x, y, Integer.parseInt(assetEle.getAttribute("color")));
								}
							}
						}
							
						assetList[i] = new Asset(tempImg, assetPos, assetSize);
					}
					
					map.setAssets(assetList);
					
					this.model.setMap(map);
				} catch (ParserConfigurationException | SAXException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			break;
		case EXIT:
			this.model.setRun(false);
			break;
		}
	}
	
}
