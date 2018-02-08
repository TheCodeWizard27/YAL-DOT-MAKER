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
	public DrawEngine(Game game){
		super("YAL DOT PLAYER");
		this.setSize(800,600);
		
		this.canvas = new Canvas(game);
		this.add(this.canvas);
		this.setVisible(true);
	}
	
	/**
	 * 
	 * @param game	gives the constructor the game 
	 * @return 		returns always the same pointer to drawEngine
	 */
	public DrawEngine getDrawEngine(Game game) {
		if(DrawEngine.drawEngine == null) {
			DrawEngine.drawEngine = new DrawEngine(game);
		}
		
		return DrawEngine.drawEngine;
	}
}
