package Jeu;

import Data.Message;
import java.util.Scanner;

public class Compagnie extends Propriete {
    
    public Compagnie (int num, String nom, Joueur proprietaire, int prixAchat, int prixLoyer){
            super(num, nom, proprietaire, prixAchat, prixLoyer);
        }
    
    
    
        @Override
	public Propriete action(Joueur aJ, int sommeLances) {
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
               else if (jProprio != aJ) {
                   int l = this.calculLoyer(sommeLances);
                   aJ.payerLoyer(l);
                   jProprio.recevoirLoyer(l);
               }
               return this;
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
        return nbCompagnies*sommeLances;
    }
}
        
 