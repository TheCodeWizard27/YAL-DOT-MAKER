package core;

import javax.swing.JFrame;

import graphics.Canvas;

public class DrawEngine extends JFrame{
	static private DrawEngine drawEngine;
	private Canvas canvas;
	
	/**
	 * 
	 * @param game	gives canvas information of the game
	 * 				to draw
	 */
	private DrawEngine(Game game){
		super("YAL DOT PLAYER");
		this.setSize(800,639);
		
		this.canvas = new Canvas(game);
		this.add(this.canvas);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * 
	 * @param game	gives the constructor the game 
	 * @return 		returns always the same pointer to drawEngine
	 */
	public static DrawEngine getInstance(Game game) {
		if(DrawEngine.drawEngine == null) {
			DrawEngine.drawEngine = new DrawEngine(game);
		}
		
		return DrawEngine.drawEngine;
	}
}
