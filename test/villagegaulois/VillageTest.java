package villagegaulois;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controleur.ControlEmmenager;
import personnages.Chef;
import personnages.Gaulois;

class VillageTest {
	private Village village;
	private Chef kira;
	private Gaulois josuke = new Gaulois("Josuke",5);
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("Morio", 10, 5);
		kira = new Chef("Kira", 10, village);
		village.setChef(kira);
		
	}

	@Test
	void testVillage() {
		assertNotNull(village, "Constructeur ne renvoie pas null");
	}

	@Test
	void testGetNom() {
		assertEquals("Morio",village.getNom());
	}

	@Test
	void testSetChef() {
		Chef jotaro = new Chef("Jotaro", 10, village);
		assertEquals(village.trouverHabitant("Kira"),kira);
		village.setChef(jotaro);
		assertEquals(village.trouverHabitant("Jotaro"),jotaro);
		
	}

	@Test
	void testAjouterHabitant() {
		assertNull(village.trouverHabitant("Josuke"));
		village.ajouterHabitant(josuke);
		assertNotNull(village.trouverHabitant("Josuke"));
	}

	@Test
	void testTrouverHabitant() {
		village.ajouterHabitant(josuke);
		assertEquals(village.trouverHabitant("Josuke"),josuke);
	}

	@Test
	void testDonnerVillageois() {
		Gaulois koichi = new Gaulois("Koichi",3);
		village.ajouterHabitant(josuke);
		village.ajouterHabitant(koichi);
		assertNotNull(village.donnerVillageois());
		
	}

	@Test
	void testDonnerNbEtal() {
		fail("Not yet implemented");
	}

	@Test
	void testInstallerVendeur() {
		fail("Not yet implemented");
	}

	@Test
	void testPartirVendeur() {
		fail("Not yet implemented");
	}

	@Test
	void testRechercherEtalVide() {
		fail("Not yet implemented");
	}

	@Test
	void testRechercherVendeursProduit() {
		fail("Not yet implemented");
	}

	@Test
	void testRechercherEtal() {
		fail("Not yet implemented");
	}

	@Test
	void testDonnerEtatMarche() {
		fail("Not yet implemented");
	}

}