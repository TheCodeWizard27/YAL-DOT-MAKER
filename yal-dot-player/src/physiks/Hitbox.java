package physiks;

import graphics.Vector2f;

public class Hitbox {
	private Vector2f pos;
	private Vector2f size;
	private Vector2f pos2;
	
	public Hitbox(Vector2f pos, Vector2f size) {
		this.pos = pos;
		this.size = size;
		this.pos2 = new Vector2f(pos.getX() + size.getX(), pos.getY() + size.getY());
	}
	
	public Hitbox(float x, float y, float width, float height) {
		this.pos = new Vector2f(x,y);
		this.size = new Vector2f(width,height);
		this.pos2 = new Vector2f(x + width, y + height);
	}

	/**
	 * Checks if another hitbox is intersection with the current
	 * @param 	hitbox the other hitbox that gets profen
	 * @return 	if they are intersecting
	 */
	public boolean hitboxIntersection(Hitbox hitbox) {
		return this.pointIntersection(hitbox.getPos()) && this.pointIntersection(hitbox.getPos2());
	}
	/**
	 * Checks if point is inside of hitbox
	 * @param 	point which gets checked
	 * @return	if the point is inside
	 */
	public boolean pointIntersection(Vector2f point) {
		return point.getX() >= this.pos.getX() && point.getX() <= this.pos2.getX() && point.getY() >= this.pos.getY() && point.getY() <= this.pos2.getY();
	}
	
	public Vector2f getPos() {
		return pos;
	}
	public void setPos(Vector2f pos) {
		this.pos.setPos(pos);
		this.pos2.setPos(pos.getX()+this.size.getX(),pos.getY()+this.size.getY());
	}
	public void setPos(float x, float y) {
		this.pos.setPos(x,y);
		this.pos2.setPos(x+this.size.getX(),y+this.size.getY());
	}
	
	public Vector2f getSize() {
		return size;
	}
	public void setSize(Vector2f size) {
		this.size.setPos(size);
		this.pos2.setPos(this.pos.getX()+size.getX(),this.pos.getY()+size.getY());
	}
	public void setSize(float x, float y) {
		this.size.setPos(x,y);
		this.pos2.setPos(this.pos.getX()+x,this.pos.getY()+y);
	}
	
	public Vector2f getPos2() {
		return pos2;
	}
}
