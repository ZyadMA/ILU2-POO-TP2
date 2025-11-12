package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis desolee "+ nomVendeur + " mais il faut etre un habitant de notre village pour commercer ici.");
		}else {
			System.out.println("Bonjour " + nomVendeur + " , je vais regarder si je peux vous trouver un etal.");
			
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Desole " + nomVendeur + " je n'ai plus d'etal qui ne soit pas deja occupe.");
			}else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait , il me reste un etal pour vous ! \n");
		System.out.println("Il me faudrait quelques renseignements : \n");
		
		String produit = Clavier.entrerChaine("Quel produit souhaitez vous vendre?\n");
		int nbPrdouit = Clavier.entrerEntier("Combien souhaitez vous vendre?\n");
		
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbPrdouit);
		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + "s'est installe a l'etal numero" + numeroEtal + "\n");
		}
	}
}

