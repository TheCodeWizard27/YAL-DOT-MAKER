package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.Timer;

public class Controller implements ActionListener, MouseMotionListener, MouseListener, KeyListener, MouseWheelListener{
	private Model model;
	private View view;
	private Timer timer;
	
	public Controller() {
		this.model = new Model();
		this.view = View.getInstance(this.model);
		
		this.view.getCanvas().addKeyListener(this);
		this.view.getCanvas().addMouseWheelListener(this);
		
		this.timer = new Timer(20,this);
		this.timer.start();
	}
	
	/**
	 * Automatically updates view if normal repainter's not added
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.repaint();
		System.out.println(this.model.getMap().getName());
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_CONTROL:
			this.model.setCtrl(true);
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_CONTROL:
			this.model.setCtrl(false);
			break;
		}
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
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(this.model.isCtrl()) {
			if(e.getWheelRotation() < 0 && this.model.getZoom() < 500) {
				this.model.setZoom(this.model.getZoom() + 10f);
			}else if(e.getWheelRotation() > 0 && this.model.getZoom() > 20){
				this.model.setZoom(this.model.getZoom() - 10f);
			}
			this.view.getInfoBar().getZoom().setText("Zoom: " + Integer.toString((int)this.model.getZoom())+"%");
			this.view.getCanvas().getCanvas().setViewportView(this.view.getCanvas());
		}
	}
}
