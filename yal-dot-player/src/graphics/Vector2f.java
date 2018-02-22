package graphics;

/**
 * Vector2f class for defining a point in space
 * @author bschab
 *
 */
public class Vector2f {
	private float x;
	private float y;
	
	/**
	 * constructors
	 * @param vector
	 */
	public Vector2f(Vector2f vector) {
		this.x = vector.getX();
		this.y = vector.getY();
	}
	public Vector2f(float x , float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Vector operation function
	 * sets vector anew
	 * @param x
	 * @param y
	 */
	public void setVector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * sets vector to a certain vector
	 * @param vector
	 */
	public void setVector2f(Vector2f vector) {
		this.x = vector.getX();
		this.y = vector.getY();
	}
	/**
	 * adds x, y to vector
	 * @param x
	 * @param y
	 */
	public void addToBoth(float x, float y) {
		this.x += x;
		this.y += y;
	}
	/**
	 * adds vector to vector
	 * @param vector
	 */
	public void addToBoth(Vector2f vector) {
		this.x += vector.getX();
		this.y += vector.getY();
	}
	/**
	 * adds to x position
	 * @param x
	 */
	public void addToX(float x) {
		this.x += x;
	}
	/**
	 * adds to y position
	 * @param y
	 */
	public void addToY(float y) {
		this.y += y;
	}
	
	/**
	 * getters n' setters
	 * @return
	 */
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
}

