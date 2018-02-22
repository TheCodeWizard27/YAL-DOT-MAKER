package core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class InputHandler implements KeyListener{
	private Set<Integer> inputBuffer = new HashSet<Integer>();
	
	/**
	 * implemented keylistener methods that handle input
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		this.inputBuffer.add(e.getKeyCode());
	}
	@Override
	public void keyReleased(KeyEvent e) {
		this.inputBuffer.remove(e.getKeyCode());
	}
	
	/**
	 * getter and setter
	 * @return
	 */
	public Set<Integer> getInputBuffer() {
		return inputBuffer;
	}
	public void setInputBuffer(Set<Integer> inputBuffer) {
		this.inputBuffer = inputBuffer;
	}
	
	/**
	 * unused functions
	 */
	@Override
	public void keyTyped(KeyEvent e) {}
}
