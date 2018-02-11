package core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashSet;
import java.util.Set;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener{
	private Set<Integer> inputBuffer = new HashSet<Integer>();
	
	@Override
	public void keyPressed(KeyEvent e) {
		this.inputBuffer.add(e.getKeyCode());
	}
	@Override
	public void keyReleased(KeyEvent e) {
		this.inputBuffer.remove(e.getKeyCode());
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
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
	
	public Set<Integer> getInputBuffer() {
		return inputBuffer;
	}
	public void setInputBuffer(Set<Integer> inputBuffer) {
		this.inputBuffer = inputBuffer;
	}
}
