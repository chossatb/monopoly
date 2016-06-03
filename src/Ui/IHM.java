package Ui;

import Jeu.*;

public class IHM {
	public Controleur controleur;
        
        
        public IHM(){
            this.controleur= new Controleur(this, null);
        }

	public void afficher() {
		throw new UnsupportedOperationException();
	}
        
        public void infoJoueur(Joueur aJ, int de1, int de2){
            System.out.println("Position = " + aJ.getPosCourante().getNumero() + " " + de1 + "et" + de2 + " : " + aJ.getNom() + " - >  " + aJ.getPosCourante().getNomCarreau());
        }
        
        public void joueurSupprime(String nom){
            System.err.println("Le joueur " + nom + " supprimé !");
        }
        
        public void joueurAGagne(String nom){
            System.out.println("Le joueur " + nom + " a gagné !");
        }
}