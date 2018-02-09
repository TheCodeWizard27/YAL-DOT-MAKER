package core;

import javax.swing.JFrame;

import graphics.Canvas;

public class View extends JFrame{
	private static View view;
	private Model model;
	private Canvas canvas;
	
	private View(Model model) {
		super("YAL DOT MAKER");
		this.setSize(1200,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		this.model = model;
		this.canvas = new Canvas(model);
		
		this.add(this.canvas);
	}
	
	public static View getInstance(Model model) {
		if(View.view == null) {
			View.view = new View(model);
		}
		
		return View.view;
	}
}
