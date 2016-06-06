package Jeu;


import Data.Message;


public class Gare extends Propriete {
        
        public Gare (int num, String nom, Joueur proprietaire, int prixAchat, int prixLoyer){
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
                this.acheterPropriete(aJ); 
                mess.type=Message.Types.PASSER;
                return mess;
            }
               
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
