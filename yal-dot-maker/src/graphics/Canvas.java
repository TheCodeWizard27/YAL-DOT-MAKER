package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
		
		this.setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension((int)this.model.getMap().getSize().getX(),(int)this.model.getMap().getSize().getY()));
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		this.setPreferredSize(new Dimension((int)this.model.getMap().getSize().getX(),(int)this.model.getMap().getSize().getY()));
		
		BufferedImage testImg = new BufferedImage(1200,800,BufferedImage.TYPE_INT_ARGB);
		Graphics2D tg2d = (Graphics2D) testImg.getGraphics();
		
		tg2d.fillRect(0, 0, (int)this.model.getMap().getSize().getX(), (int)this.model.getMap().getSize().getY());
		
		g2d.drawImage(testImg, 0, 0, null);
		
	}
	
	public JScrollPane getCanvas() {
		return this.scrollBar;
	}
}
