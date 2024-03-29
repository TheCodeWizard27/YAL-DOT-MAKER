package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.Timer;

/**
 * Controller class controlls the programm
 * @author bschab
 *
 */
public class Controller implements ActionListener, KeyListener, MouseWheelListener{
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
		this.view.getObjectList().update();
	}
	
	/**
	 * Automatically updates view and information about it
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.model.setCurrentObj(this.view.getObjectList().getObjects().get(this.view.getObjectList().getList().getSelectedValue()));
		if(this.model.getCurrentObj() != null) {
			this.view.getInfoBar().getCurrObj().setText("Current Object : " + this.view.getObjectList().getList().getSelectedValue());
			this.view.getInfoBar().getPos().setText("Current X/Y : " + this.model.getCurrentObj().getPos().getX() + " / " + this.model.getCurrentObj().getPos().getY() + " ");
		}
		this.view.repaint();
	}
	
	/**
	 * Key press function for toggeling between zooming mode
	 */
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
	
	/**
	 * mouseWheel listener function handles zooming
	 */
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
	
	/**
	 * getters n' setters
	 * @return
	 */
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public View getView() {
		return view;
	}
	public void setView(View view) {
		this.view = view;
	}

	/**
	 * unused methods
	 */
	@Override
	public void keyTyped(KeyEvent e) {}
}
