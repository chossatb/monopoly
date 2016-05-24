package Jeu;



public class Gare extends Propriete {
        
        public Gare (int num, String nom, Joueur proprietaire, int prixAchat, int prixLoyer){
            super(num, nom, proprietaire, prixAchat, prixLoyer);
        }

	public void action(Joueur aJ) {
		throw new UnsupportedOperationException();
	}

	public String getNom() {
		throw new UnsupportedOperationException();
            
	}
}
