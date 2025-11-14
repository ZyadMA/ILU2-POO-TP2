package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GauloisTest {
	private Gaulois kakyoin;

	@BeforeEach
	public void init(){
		kakyoin = new Gaulois("Kakyoin",4);
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testPrendreParole() {
		fail("Not yet implemented");
	}

	@Test
	void testGaulois() {
		Gaulois joseph = null;
		assertNull(joseph);
		
		joseph = new Gaulois("Joseph",7);
		assertNotNull(joseph);
		assertEquals(joseph.getNom(),"Joseph");
		assertEquals(joseph.getForce(),7);
	}

	@Test
	void testBoirePotion() {
		fail("Not yet implemented");
	}

}
