package Jeu;

import Data.Message;


public class Compagnie extends Propriete {
    
    public Compagnie (int num, String nom, Joueur proprietaire, int prixAchat, int prixLoyer){
            super(num, nom, proprietaire, prixAchat, prixLoyer);
        }
    
    
    
    @Override
	public Message action(Joueur aJ, int sommeLances, String choix) {
            Data.Message mess = new Message();
            if (choix.equals("y")){ 
                this.acheterPropriete(aJ); 
                mess.type=Message.Types.ACHAT_PROPRIETE;
                return mess;
            } else{
                mess.type=Message.Types.PASSER;
                return mess;
            }
               

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
        
 
