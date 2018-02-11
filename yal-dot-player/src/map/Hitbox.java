package map;

import graphics.Vector2f;

public class Hitbox {
	private Vector2f pos;
	private Vector2f size;
	private Vector2f pos2;
	
	public Hitbox(Hitbox hitbox) {
		this.pos = new Vector2f(hitbox.getPos());
		this.size = new Vector2f(hitbox.getSize());
		this.pos2 = new Vector2f(hitbox.getPos2());
	}
	
	public Hitbox(Vector2f pos, Vector2f size) {
		this.pos = pos;
		this.size = size;
		this.pos2 = new Vector2f(pos.getX(),pos.getY());
		this.pos2.addToBoth(size);
	}
	
	public Hitbox(float x, float y, float width, float height) {
		this.pos = new Vector2f(x,y);
		this.size = new Vector2f(width,height);
		this.pos2 = new Vector2f(x,y);
		this.pos2.addToBoth(this.size);
	}

	public boolean hitboxIntersect(Hitbox hitbox) {
		return this.pos2.getX() > hitbox.getPos().getX() && this.pos.getX() < hitbox.getPos2().getX() && this.pos2.getY() > hitbox.getPos().getY() && this.pos.getY() < hitbox.getPos2().getY();
	}
	
	public boolean vectorIntersect(Vector2f point) {
		return point.getX() > this.pos.getX() && point.getX() < this.pos2.getX() && point.getY() > this.pos.getY() && point.getY() < this.pos2.getY();
	}
	
	public Vector2f getPos() {
		return pos;
	}
	public void setPos(Vector2f pos) {
		this.pos.setVector2f(pos);
		this.pos2.setVector2f(pos);
		this.pos2.addToBoth(this.size);
	}

	public Vector2f getSize() {
		return size;
	}
	public void setSize(Vector2f size) {
		this.size.setVector2f(size);
		this.pos2.setVector2f(this.pos);;
		this.pos2.addToBoth(size);
	}

	public Vector2f getPos2() {
		return pos2;
	}
}