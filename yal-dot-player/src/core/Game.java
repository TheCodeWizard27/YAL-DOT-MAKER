package core;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import graphics.Vector2f;
import objects.Player;
import physiks.Hitbox;

public class Game {
	private boolean run = true;
	private Set<Integer> keyBuffer = new HashSet<Integer>();
	private DrawEngine drawengine;
	private EventHandler eventHandler;
	private Map map;
	
	public Game() {
		this.setMap(new Map(null,null));
		
		this.drawengine = DrawEngine.getInstance(this);
		this.eventHandler = EventHandler.getInstance(this);
		this.drawengine.addKeyListener(this.eventHandler);
		
		//main loop
		while(this.run) {
			double startTime = System.nanoTime();
			
			//inner loop
			this.handleInput(System.nanoTime()-startTime);
			this.update(System.nanoTime()-startTime);
			this.drawengine.repaint();
		}
	}
	
	/**
	 * Updates objects and checks hitboxes
	 * @param delta		the time it took for the last action
	 */
	public void update(double delta) {
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
	public void handleInput(double delta) {
		try {
		for(int key : this.keyBuffer) {
			switch(key) {
			case KeyEvent.VK_W: case KeyEvent.VK_UP:
				break;
			case KeyEvent.VK_A: case KeyEvent.VK_LEFT:
				break;
			case KeyEvent.VK_S: case KeyEvent.VK_DOWN:
				break;
			case KeyEvent.VK_D: case KeyEvent.VK_RIGHT:
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
}
