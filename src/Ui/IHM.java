package Ui;

import Jeu.*;
import java.util.Scanner;

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
        
        public String choixPayer(int cash,int prix){
            Scanner sc = new Scanner(System.in);
            System.out.println("Argent total avant = " + cash);
            System.out.println("Voulez vous acheter la case ? (y/n)" + " (Prix = " + prix + " )");
            String saisie=sc.nextLine();
            return saisie;
        }
        
        public void achatEffectue(int cash){
            System.out.println("Achat effectué ! ");
            System.out.println("Argent total apres = " + cash);
        }
        
        public void passer(){
            System.out.println("Achat refusé");
        }
}