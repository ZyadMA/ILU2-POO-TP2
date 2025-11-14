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
	private Gaulois koichi = new Gaulois("Koichi",3);
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("Morio", 10, 3);
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
		village.ajouterHabitant(josuke);
		village.ajouterHabitant(koichi);
		assertNotNull(village.donnerVillageois());
		
	}

	@Test
	void testDonnerNbEtal() {
		assertEquals(village.donnerNbEtal(),3);
		
	}

	@Test
	void testInstallerVendeur() {
		assertEquals(village.installerVendeur(josuke, "Crazy Diamond", 1),0);
		assertEquals(village.installerVendeur(koichi, "Echoes", 1),1);
		
	}

	@Test
	void testPartirVendeur() {
		village.installerVendeur(josuke, "Crazy Diamond", 1);
		village.installerVendeur(koichi, "Echoes", 1);
		assertEquals(village.donnerEtatMarche().length/3 , 2);
		village.partirVendeur(josuke);
		assertEquals(village.donnerEtatMarche().length/3 , 1);
		assertFalse(village.rechercherEtal(josuke).isEtalOccupe());
	}

	@Test
	void testRechercherEtalVide() {
		Gaulois jotaro = new Gaulois("Jotaro",10);
		village.installerVendeur(jotaro, "Star Platinum", 1);
		village.installerVendeur(josuke, "Crazy Diamond", 1);
		village.installerVendeur(koichi, "Echoes", 1);
		
		assertFalse(village.rechercherEtalVide());
		village.partirVendeur(josuke);
		assertTrue(village.rechercherEtalVide());
	}

	@Test
	void testRechercherVendeursProduit() {
		village.installerVendeur(josuke, "Crazy Diamond", 1);
		assertEquals(village.rechercherVendeursProduit("Crazy Diamond")[0],josuke);
	}

	@Test
	void testRechercherEtal() {
		assertNull(village.rechercherEtal(josuke));
		village.installerVendeur(josuke, "Crazy Diamond", 1);
		assertNotNull(village.rechercherEtal(josuke));
	}

	@Test
	void testDonnerEtatMarche() {
		assertEquals(village.donnerEtatMarche().length,0);
		village.installerVendeur(josuke, "Crazy Diamond", 5);
		assertEquals(village.donnerEtatMarche().length,3);
		assertEquals(village.donnerEtatMarche()[0],"Josuke");
		assertEquals(village.donnerEtatMarche()[1],"5");
		assertEquals(village.donnerEtatMarche()[2],"Crazy Diamond");
	}

}




