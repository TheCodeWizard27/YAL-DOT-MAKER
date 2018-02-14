package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import GUI.Map;
import core.Model;

public class Canvas extends JPanel{
	private Model model;
	private JScrollPane scrollBar;
	
	public Canvas(Model model) {
		super();
		this.model = model;
		
		this.scrollBar = new JScrollPane(this);
		this.scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		this.setPreferredSize(new Dimension((int)this.model.getMap().getSize().getX(),(int)this.model.getMap().getSize().getY()));
	}
	
	public void paintComponent(Graphics g) {
		//declare for use
		Graphics2D g2d = (Graphics2D) g;
		float zoom = this.model.getZoom()/100;
		Map map = this.model.getMap();
		BufferedImage display = new BufferedImage((int)(map.getSize().getX()*zoom),(int)(map.getSize().getY()*zoom),BufferedImage.TYPE_INT_ARGB);
		Graphics2D tg2d = (Graphics2D) display.getGraphics();
		
		this.setPreferredSize(new Dimension((int)(map.getSize().getX()*zoom),(int)(map.getSize().getY()*zoom)));
		float imgX = (this.getWidth()/2)-((map.getSize().getX()*zoom)/2);
		float imgY = (this.getHeight()/2)-((map.getSize().getY()*zoom)/2);
		
		g2d.setColor(new Color(150,150,150));
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		tg2d.setColor(Color.WHITE);
		tg2d.fillRect(0, 0, (int)(map.getSize().getX()*zoom), (int)(map.getSize().getY()*zoom));
		tg2d.scale(zoom, zoom);	
		
		//drawing
		
		//end drawing
		
		g2d.drawImage(display, (int)imgX, (int)imgY, null);
	}
	
	public JScrollPane getCanvas() {
		return this.scrollBar;
	}
}
