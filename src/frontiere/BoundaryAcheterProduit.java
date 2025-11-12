package frontiere;

import controleur.ControlAcheterProduit;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		
		if (controlAcheterProduit.isHabitant(nomAcheteur)) {
		
			StringBuilder questionProduit = new StringBuilder();
			StringBuilder questionVendeur = new StringBuilder();
			StringBuilder questionNombre = new StringBuilder();
			questionProduit.append("Quel produit voulez vous acheter ?");
			String produit = Clavier.entrerChaine(questionProduit.toString());
			Etal[] etals = controlAcheterProduit.rechercherEtalsProduit(produit);
			if (etals.length==0) {
				System.out.println("Désolé, personne ne vend ce produit au marché\n");
				return;
			}
			for (int i = 0; i<etals.length; i++) {
				questionVendeur.append(i+1);
				questionVendeur.append(" - ");
				questionVendeur.append(etals[i].getVendeur().getNom());
				questionVendeur.append("\n");
			}
			
			int vendeur = Clavier.entrerEntier(questionVendeur.toString());
			while (vendeur<=0 || vendeur>etals.length) {
				vendeur = Clavier.entrerEntier(questionVendeur.toString());
			}
			vendeur -= 1;
			
			System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + etals[vendeur].getVendeur().getNom() + "\nBonjour " + nomAcheteur);
			
			questionNombre.append("Combien de ");
			questionNombre.append(produit);
			questionNombre.append(" voulez-vous acheter ?");
			int nombreAchete = Clavier.entrerEntier(questionNombre.toString());
			
			int quantiteRestante = etals[vendeur].getQuantite();
			if(nombreAchete > quantiteRestante && quantiteRestante!=0) {
				System.out.println(nomAcheteur + " veut acheter " + nombreAchete + " " + produit + ", malheureusement " + etals[vendeur].getVendeur().getNom() + " n'en a plus que " + quantiteRestante + ". " + nomAcheteur + " achète tout le stock de " + etals[vendeur].getVendeur().getNom() + ".");
			} else if (quantiteRestante == 0){
				System.out.println(nomAcheteur + " veut acheter " + nombreAchete + " " + produit + ", malheureusement il n'y en a plus !");
			} else {
				System.out.println(nomAcheteur + " achète " + nombreAchete + " " + produit + " à " + etals[vendeur].getVendeur().getNom() + ".");
			}
			controlAcheterProduit.acheterProduit(etals[vendeur].getVendeur().getNom(), nombreAchete);
			
			
			
		}else {
			System.out.println("Je suis désolé " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
		}
	}
}