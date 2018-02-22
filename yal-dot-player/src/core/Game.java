package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import graphics.Vector2f;
import map.Hitbox;
import map.Player;
import mode.Map;
import mode.Mode;

/**
 * main class of the programm
 * @author bschab
 *
 */
public class Game implements ActionListener{
	private static Game game;
	
	private InputHandler inputHandler;
	private DrawEngine drawEngine;
	private Model model;
	
	private Timer fpsTimer;
	
	private Game() {
		this.model = new Model();
		this.inputHandler = new InputHandler();
		this.drawEngine = DrawEngine.getInstance(this.model);
		this.drawEngine.addKeyListener(this.inputHandler);
		
		this.fpsTimer = new Timer(20,this);
		this.fpsTimer.start();
	}
	
	/**
	 * Implemented ActionListener function
	 * that has game loop
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.model.shouldRun()) {
			if(this.model.getMode() == Mode.IN_GAME && this.model.getMap() != null) {
				this.handleInput();
				this.update();
			}
			this.drawEngine.repaint();
		}else {
			this.drawEngine.dispose();
		}
	}
	
	/**
	 * Handels accordingly to input
	 */
	public void handleInput() {
		Player player = this.model.getMap().getPlayer();
		
		for(int key : this.inputHandler.getInputBuffer()) {
			switch(key) {
			case KeyEvent.VK_W: case KeyEvent.VK_SPACE: case KeyEvent.VK_UP:
				if(!player.isInAir())
					player.setJumping(true);
				break;
			case KeyEvent.VK_A: case KeyEvent.VK_LEFT:
				player.setMovL(true);
				break;
			case KeyEvent.VK_D: case KeyEvent.VK_RIGHT:
				player.setMovR(true);
				break;
			case KeyEvent.VK_Q:
				player.setPos(this.model.getMap().getStartPos());
				break;
			case KeyEvent.VK_T:
				if(this.model.isHitboxVisible())
					this.model.setHitboxVisible(false);
				else
					this.model.setHitboxVisible(true);
				break;
			}
		}
	}
	
	/**
	 * Updates the game checks hitboxes
	 */
	public void update() {
		Map map = this.model.getMap();
		Player player = map.getPlayer();
		
		//movement handling
		if(player.isMovL()) {
			if(player.getSpeed().getX() > Player.MAX_WALK_SPEED*-1) {
				player.getSpeed().addToX(Player.WALK_SPEED*-1);
			}
		}else if(player.isMovR()) {
			if(player.getSpeed().getX() < Player.MAX_WALK_SPEED) {
				player.getSpeed().addToX(Player.WALK_SPEED);
			}
		}else {
			player.getSpeed().setX(0);
		}
		
		if(player.isJumping()) {
			if(player.getSpeed().getY() > Player.MAX_JUMP_HEIGHT*-1) {
				player.getSpeed().addToY(Player.JUMP_HEIGHT*-1);
			}else {
				player.setInAir(true);
			}
		}else {
			player.getSpeed().addToY(0.5f);
			player.setInAir(true);
		}
		
		player.getPos().addToBoth(player.getSpeed());
		player.getHitbox().setPos(player.getPos());
		
		if(player.getHitbox().getPos().getX() < map.getBounds().getPos().getX()) {
			player.getPos().addToX(map.getBounds().getPos().getX() - player.getHitbox().getPos().getX());
			player.getSpeed().setX(0);
			player.setInAir(true);
		}else if(player.getHitbox().getPos2().getX() > map.getBounds().getPos2().getX()){
			player.getPos().addToX(map.getBounds().getPos2().getX() - player.getHitbox().getPos2().getX()-1);
			player.getSpeed().setX(0);
			player.setInAir(true);
		}
		
		//handles physik
		for(Hitbox hitbox : map.getHitboxes()) {
			if(player.getHitbox().hitboxIntersect(hitbox)) {
				
				if(player.getSpeed().getX() > 0 && player.getPos().getX() < hitbox.getPos().getX()) {
					player.getSpeed().setX(0);
					player.getPos().addToX(hitbox.getPos().getX() - player.getHitbox().getPos2().getX());
				}else if(player.getSpeed().getX() < 0 && player.getHitbox().getPos2().getX() > hitbox.getPos2().getX()) {
					player.getSpeed().setX(0);
					player.getPos().addToX(player.getPos().getX() - hitbox.getPos2().getX());
				}else if(player.isJumping()){
					player.getSpeed().setY(0);
					player.getPos().addToY((hitbox.getPos2().getY() - player.getPos().getY()));
					player.setInAir(true);
				}else {
					player.setInAir(false);
					player.getSpeed().setY(0);
					player.getPos().addToY(hitbox.getPos().getY() - player.getHitbox().getPos2().getY());
				}
			}
		}
		
		//deathbox handling
		for(Hitbox hitbox : map.getDeathboxes()) {
			if(player.getHitbox().hitboxIntersect(hitbox)) {
				player.setSpeed(new Vector2f(0,0));
				player.setPos(map.getStartPos());
			}
		}
		
		//Goalbox handling
		for(Hitbox hitbox : map.getGoalboxes()) {
			if(player.getHitbox().hitboxIntersect(hitbox)) {
				player.setSpeed(new Vector2f(0,0));
				this.model.setMode(Mode.TITLESCREEN);
			}
		}
		
		map.getCamera().update(player,map.getBounds());		//updates camera position
		player.setMovL(false);
		player.setMovR(false);
		player.setJumping(false);
	}
	
	/**
	 * Singelton get Instance Function
	 */
	public static Game getInstance() {
		if(Game.game == null)
			Game.game = new Game();
		return Game.game;
	}
	
	/**
	 * getters n' setters
	 */
	public InputHandler getInputHandler() {
		return inputHandler;
	}
	public void setInputHandler(InputHandler inputHandler) {
		this.inputHandler = inputHandler;
	}
	public DrawEngine getDrawEngine() {
		return drawEngine;
	}
	public void setDrawEngine(DrawEngine drawEngine) {
		this.drawEngine = drawEngine;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
}
