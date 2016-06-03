package Jeu;

import Data.Message;
import java.util.Scanner;

public class Compagnie extends Propriete {
    
    public Compagnie (int num, String nom, Joueur proprietaire, int prixAchat, int prixLoyer){
            super(num, nom, proprietaire, prixAchat, prixLoyer);
        }
    
    
    
        @Override
	public void action(Joueur aJ, int sommeLances) {
               Data.Message mess = new Message();
               Scanner sc = new Scanner(System.in);
               Joueur jProprio = this.getProprietaire();
               if (jProprio == null){
                   
                   mess.quest_achat = "Voulez vous acheter la compagnie ? (y/n) " + " (Prix = " + this.getPrixAchat();
                   mess.type = Message.Types.ACHETER_OU_PAS;
                   
                   System.out.println("Argent total avant = " + aJ.getCash());
                   System.out.println("Voulez vous acheter la compagnie ? (y/n)" + " (Prix = " + this.getPrixAchat());
                   String saisie=sc.nextLine();
                   if (saisie.equals("y")){ 
                       this.acheterPropriete(aJ); 
                       System.out.println("Argent total apres = " + aJ.getCash());
                   }
               }
               super.action(aJ, sommeLances);

        }
    
    @Override
    public boolean acheterPropriete(Joueur j){
        if(j.getCash() >= this.getPrixAchat()){
            this.setProprietaire(j);
            j.diminuerCash(this.getPrixAchat());
            j.addCompagnie(this);
            return true;
        }
        else{
            return false;
        }

    }
    
    @Override
    public int calculLoyer(int sommeLances) { // a changer
        Joueur j = this.getProprietaire();
        int nbCompagnies = j.getNbCompagnies();
        int i = 0;
        if (nbCompagnies == 1){
            i = 4;
        } else if (nbCompagnies == 2){
            i = 10;
        }
        return i*sommeLances;
    }
}
        
 
