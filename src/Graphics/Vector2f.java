package Graphics;

public class Vector2f {
	private float x;
	private float y;
	
	/**
	 * Default Constructor for a point in Space x/y
	 * @param x
	 * @param y
	 */
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * sets x and y pos of vector
	 * @param vector 
	 */
	public void setPos(Vector2f vector) {
		this.x = vector.getX();
		this.y = vector.getY();
	}
	/**
	 * sets x and y pos of vector
	 * @param x
	 * @param y
	 */
	public void setPos(float x, float y) {
		this.x = x;
		this.y = y;
	}
	public float getX() {
		return this.x;
	}
	public float getY() {
		return this.y;
	}
}
