package core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class EventHandler implements MouseMotionListener, MouseListener, KeyListener{
	private static EventHandler eventHandler;
	private Game game;
	
	public static EventHandler getInstance(Game game) {
		if(EventHandler.eventHandler == null) {
			EventHandler.eventHandler = new EventHandler(game);
		}
		
		return EventHandler.eventHandler;
	}
	
	private EventHandler(Game game) {
		this.game = game;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		game.addInput(e.getKeyCode());
	}
	@Override
	public void keyReleased(KeyEvent e) {
		game.removeInput(e.getKeyCode());
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
