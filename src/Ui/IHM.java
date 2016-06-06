package Ui;

import Jeu.*;
import java.util.Scanner;

public class IHM {
	public Controleur controleur;
        
        
        public IHM(Monopoly monopoly){
            this.controleur= new Controleur(this, monopoly);
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
        
        public Joueur creerJoueur() {
            Scanner sc = new Scanner(System.in);
            String rep = sc.nextLine();
            Joueur j = new Joueur(rep, controleur.getMonopoly().getCarreau(1));
            return j;
        }
        
        public void creerJoueurs() {
            boolean ok = false;
            int nbj = 0;
            
            while (!ok){
                Scanner sc = new Scanner(System.in);
                System.out.print("Nombre de joueurs : ");
                String rep = sc.nextLine();
                nbj = Integer.parseInt(rep);
                System.out.println("");
                if (nbj < 2){
                    System.out.println("Il faut au moins 2 joueurs !");
                }else if (nbj > 6){
                    System.out.println("Il faut au maximum 6 joueurs !");
                }else{
                    ok = true;
                }
            }
            for (int i = 1; i <= nbj; i++){
                System.out.print("Nom du joueur "+i+" : ");
                Joueur j = creerJoueur();
                controleur.getMonopoly().getJoueurs().put(controleur.getMonopoly().getJoueurs().size(), j);
            }       
        }
        
        
}