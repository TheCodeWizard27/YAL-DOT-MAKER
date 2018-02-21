package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import map.Hitbox;

class Tests {

	/**
	 * checks if two hitboxes are actually intersecting
	 */
	@Test
	void testHitboxes() {
		Hitbox hitbox1 = new Hitbox(-10,-10,20,20);
		Hitbox hitbox2 = new Hitbox(0,0,20,20);
		
		assert(hitbox1.hitboxIntersect(hitbox2));
	}
}
