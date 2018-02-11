package map;

import graphics.Vector2f;

public class Camera {
	private Hitbox hitbox;
	private Vector2f pos;
	private Vector2f size;
	
	public Camera(Vector2f pos, Vector2f size) {
		this.pos = pos;
		this.size = size;
		this.hitbox = new Hitbox(pos,size);
	}
	public Camera(float x, float y, float width, float height) {
		this.pos = new Vector2f(x,y);
		this.size = new Vector2f(width,height);
		this.hitbox = new Hitbox(x,y,width,height);
	}
	
	public void update(Player player, Hitbox bounds) {
		Vector2f playerCenter = new Vector2f(player.getPos());
		Vector2f cameraCenter =	new Vector2f(this.pos);
		playerCenter.addToBoth(new Vector2f(16/2,32/2));
		cameraCenter.addToBoth(new Vector2f(this.size.getX()/2,this.size.getY()/2));
		
		cameraCenter.addToX((cameraCenter.getX() - playerCenter.getX())*-.1f);
		cameraCenter.addToY((cameraCenter.getY() - playerCenter.getY())*-.1f);
		cameraCenter.addToBoth(new Vector2f(this.size.getX()/-2,this.size.getY()/-2));
		
		this.pos.setVector2f(cameraCenter);
		this.hitbox.setPos(this.pos);
		
		while(this.pos.getX() + this.size.getX() > bounds.getPos2().getX()) {
			this.pos.addToX(-1f);
		}
		this.hitbox.setPos(this.pos);
		while(this.pos.getX() < bounds.getPos().getX()){
			this.pos.addToX(1f);
		}
		this.hitbox.setPos(this.pos);
		while(this.pos.getY() + this.size.getY() > bounds.getPos2().getY()) {
			this.pos.addToY(-1f);
		}
		this.hitbox.setPos(this.pos);
		while(this.pos.getY() < bounds.getPos().getY()){
			this.pos.addToY(1f);
		}
		this.hitbox.setPos(this.pos);
	}
	
	/**
	 * getters n' setters
	 * @return
	 */
	public Hitbox getHitbox() {
		return hitbox;
	}
	public void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}
	public Vector2f getPos() {
		return pos;
	}
	public void setPos(Vector2f pos) {
		this.pos = pos;
	}
	public Vector2f getSize() {
		return size;
	}
	public void setSize(Vector2f size) {
		this.size = size;
	}
}
