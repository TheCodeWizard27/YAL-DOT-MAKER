package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.Timer;

import graphics.Vector2f;
import objects.Player;
import physiks.Hitbox;

public class Game implements ActionListener{
	private boolean run = true;
	private boolean hitboxVisible = true;
	private Set<Integer> keyBuffer = new HashSet<Integer>();
	private DrawEngine drawengine;
	private EventHandler eventHandler;
	private Map map;
	private Timer fpsTimer = new Timer(40,this);
	
	public Game() {
		this.setMap(new Map(null,null));
		
		this.drawengine = DrawEngine.getInstance(this);
		this.eventHandler = EventHandler.getInstance(this);
		this.drawengine.addKeyListener(this.eventHandler);
		
		this.fpsTimer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.run) {
			//game loop
			this.handleInput();
			this.update();
			this.drawengine.repaint();
		}else {
			this.fpsTimer.stop();
		}
	}
	
	/**
	 * Updates objects and checks hitboxes
	 * @param delta		the time it took for the last action
	 */
	public void update() {
		Player player = this.map.getPlayer();
		
		//hitbox detection
		for(Hitbox hitbox : this.map.getHitboxes()) {
			if(player.getHitbox().hitboxIntersection(hitbox)) {
				float dirX = player.getRePos().getX() - player.getPos().getX();	//gets direction in the x axis
				float dirY = player.getRePos().getY() - player.getPos().getY();	//gets direction in the y axis
				
				if(dirX < 0) {
					float distance = (player.getHitbox().getPos2().getX() - hitbox.getPos().getX())-1;	//gets distance it should go back to the left
					player.setXPos(player.getPos().getX() + distance);
				}else if(dirX > 0) {
					float distance = (player.getHitbox().getPos().getX() - hitbox.getPos2().getX())+1;	//gets distance it should go back to the right
					player.setXPos(player.getPos().getX() + distance);
				}
				
				if(dirY < 0) {
					float distance = (player.getHitbox().getPos2().getY() - hitbox.getPos().getY())-1;	//gets distance it should go back upwards
					player.setYPos(player.getPos().getY() + distance);
					player.setInAir(true);
				}else if(dirY > 0) {
					float distance = (player.getHitbox().getPos().getY() - hitbox.getPos2().getY())+1;	//gets distance it should go back downwards
					player.setYPos(player.getPos().getY() + distance);
				}
			}
		}

	}
	
	/**
	 * Handels input it got from Eventhandler
	 * @param delta		the time it took for the last action
	 */
	public void handleInput() {
		Player player = this.map.getPlayer();
		
		try {
		for(int key : this.keyBuffer) {
			switch(key) {
			case KeyEvent.VK_W: case KeyEvent.VK_UP:
				player.setYSpeed(player.getSpeed().getY() - Player.JUMP_HEIGHT);
				player.setJumping(true);
				break;
			case KeyEvent.VK_A: case KeyEvent.VK_LEFT:
				player.setYSpeed(player.getSpeed().getX() - Player.WALK_SPEED);
				player.setMoving(true);
				break;
			case KeyEvent.VK_S: case KeyEvent.VK_DOWN:
				break;
			case KeyEvent.VK_D: case KeyEvent.VK_RIGHT:
				player.setYSpeed(player.getSpeed().getX() + Player.WALK_SPEED);
				player.setMoving(true);
				break;
			default:
				System.out.println(key);
			}
		}
		}catch(java.util.ConcurrentModificationException e){
			System.out.println("Error Error Error");
		}
		
	}
	
	public void addInput(int key) {
		this.keyBuffer.add(key);
	}
	public void removeInput(int key) {
		this.keyBuffer.remove(key);
	}

	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}

	public boolean isHitboxVisible() {
		return hitboxVisible;
	}
	public void setHitboxVisible(boolean hitboxVisible) {
		this.hitboxVisible = hitboxVisible;
	}
}
