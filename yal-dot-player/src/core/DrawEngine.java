package core;

import javax.swing.JFrame;

import graphics.Canvas;
/**
 * class for the JFrame
 * @author bschab
 *
 */
public class DrawEngine extends JFrame{
	private static DrawEngine drawEngine;
	private Canvas canvas;
	
	/**
	 * private singleton constructor
	 * @param model passes model information from game class
	 */
	private DrawEngine(Model model) {
		super("YAL DOT PLAYER");
		this.canvas = new Canvas(model,this);
		this.setSize(800,600);
		this.add(this.canvas);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	/**
	 * singleton instance getter of drawengine
	 * @param model
	 * @return
	 */
	public static DrawEngine getInstance(Model model) {
		if(DrawEngine.drawEngine == null)
			DrawEngine.drawEngine = new DrawEngine(model);
		return DrawEngine.drawEngine;
	}
}
