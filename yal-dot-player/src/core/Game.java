package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import map.Player;
import mode.Map;
import mode.Mode;

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
	 * Main loop
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
				player.getPos().addToY(-2.5f);
				break;
			case KeyEvent.VK_A: case KeyEvent.VK_LEFT:
				player.getPos().addToX(-2.5f);
				break;
			case KeyEvent.VK_D: case KeyEvent.VK_RIGHT:
				player.getPos().addToX(2.5f);
				break;
			case KeyEvent.VK_S: case KeyEvent.VK_DOWN:
				player.getPos().addToY(2.5f);
				break;
			case KeyEvent.VK_T:
				if(this.model.isHitboxVisible())
					this.model.setHitboxVisible(false);
				else
					this.model.setHitboxVisible(true);
				break;
			default:
				System.out.println(key);
			}
		}
	}
	
	/**
	 * Updates the game checks hitboxes
	 */
	public void update() {
		Map map = this.model.getMap();
		Player player = map.getPlayer();
		
		//add movement code later
		
		player.update();
		map.getCamera().update(player,map.getBounds());
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
	 * Public getters n' setters
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
