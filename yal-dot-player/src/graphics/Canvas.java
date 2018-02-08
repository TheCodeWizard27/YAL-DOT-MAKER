package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import core.Game;

public class Canvas extends JPanel{
	private Game game;
	
	public Canvas(Game game) {
		this.game = game;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
	}
}
