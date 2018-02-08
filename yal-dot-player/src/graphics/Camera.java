package graphics;

public class Camera {
	private static Camera camera;
	private Vector2f pos;
	private Vector2f size;
	
	private Camera() {
		this.pos = new Vector2f(0,0);
		this.size = new Vector2f(800,600);
	}
	
	public static Camera getInstance() {
		if(Camera.camera == null) {
			Camera.camera = new Camera();
		}
		
		return Camera.camera;
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
