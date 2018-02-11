package core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class InputHandler implements KeyListener{
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
	
	public Set<Integer> getInputBuffer() {
		return inputBuffer;
	}
	public void setInputBuffer(Set<Integer> inputBuffer) {
		this.inputBuffer = inputBuffer;
	}
}
