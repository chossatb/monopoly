package Jeu;

import java.util.Scanner;



public class Gare extends Propriete {
        
        public Gare (int num, String nom, Joueur proprietaire, int prixAchat, int prixLoyer){
            super(num, nom, proprietaire, prixAchat, prixLoyer);
        }

        @Override
	public void action(Joueur aJ, int sommeLances) {
               Scanner sc = new Scanner(System.in);
               Joueur jProprio = this.getProprietaire();
               if (jProprio == null){
                   System.out.println("Argent total avant = " + aJ.getCash());
                   System.out.println("Voulez vous acheter la gare ? (y/n)" + " (Prix = " + this.getPrixAchat());
                   String saisie=sc.nextLine();
                   if (saisie.equals("y")){ 
                       this.acheterPropriete(aJ); 
                       System.out.println("Argent total apres = " + aJ.getCash() );
                   }
               }
               super.action(aJ, sommeLances);
  
        }

	public String getNom() {
            return "a completer classe gare";
            
	}
        
            @Override
        public boolean acheterPropriete(Joueur j){
            if(j.getCash() >= this.getPrixAchat()){
                this.setProprietaire(j);
                j.diminuerCash(this.getPrixAchat());
                j.addGare(this);
                return true;
            }
            else{
                return false;
            }

        }
        
        @Override
          public int calculLoyer(int sommeLances) {
              Joueur j = this.getProprietaire();
              int nbGares = j.getNbGare();
              return nbGares*25;
          }
}
