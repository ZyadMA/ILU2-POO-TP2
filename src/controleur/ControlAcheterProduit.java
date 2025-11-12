package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public int acheterProduit(String nom, int nbProduitAchete) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nom);
		return etal.acheterProduit(nbProduitAchete);
	}	
	
	public boolean isHabitant(String nom) {
		return controlVerifierIdentite.verifierIdentite(nom);
	}
	
	public Etal[] rechercherEtalsProduit(String produit) {
		Gaulois[] vendeurProduit = village.rechercherVendeursProduit(produit);
		if (vendeurProduit == null) {
			return new Etal[0];
		} else {
			Etal[] etals = new Etal[vendeurProduit.length];
			for (int i = 0; i<vendeurProduit.length; i++) {
				etals[i] = controlTrouverEtalVendeur.trouverEtalVendeur(vendeurProduit[i].getNom());
			}
			return etals;
		}
		
	}
}