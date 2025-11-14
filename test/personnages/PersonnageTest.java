package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonnageTest {
	private Personnage dio;
	
	@BeforeEach
	public void init() {
		dio = new Personnage("Dio",10);
	}

	@Test
	void testPersonnage() {
		Personnage holhorse = null;
		assertNull(holhorse);
		
		holhorse = new Personnage("Holhorse",2);
		assertNotNull(holhorse);
		assertEquals(holhorse.getNom(),"Holhorse");
		assertEquals(holhorse.getForce(),2);
	}

	@Test
	void testGetForce() {
		assertEquals(dio.getForce(),10);
	}

	@Test
	void testGetNom() {
		assertEquals(dio.getNom(),"Dio");
	}

	@Test
	void testToString() {
		assertEquals(dio.toString(),"[nom=Dio, force=10]");
	}

	@Test
	void testPrendreParole() {
		assertEquals(dio.prendreParole(),"Dio : ");
	}

}
