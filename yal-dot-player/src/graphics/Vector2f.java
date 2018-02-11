package graphics;

public class Vector2f {
	private float x;
	private float y;
	
	public Vector2f(Vector2f vector) {
		this.x = vector.getX();
		this.y = vector.getY();
	}

	public Vector2f(float x , float y) {
		this.x = x;
		this.y = y;
	}
	
	public void setVector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void setVector2f(Vector2f vector) {
		this.x = vector.getX();
		this.y = vector.getY();
	}
	
	public void addToBoth(float x, float y) {
		this.x += x;
		this.y += y;
	}
	
	public void addToBoth(Vector2f vector) {
		this.x += vector.getX();
		this.y += vector.getY();
	}
	
	public void addToX(float x) {
		this.x += x;
	}
	
	public void addToY(float y) {
		this.y += y;
	}
	
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

