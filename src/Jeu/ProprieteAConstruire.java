package Jeu;


import Data.Message;

public class ProprieteAConstruire extends Propriete{
    
    private Groupe groupe;
    
    public ProprieteAConstruire (int num, String nom, Joueur proprietaire, int prixAchat, int prixLoyer, Groupe groupe){
        
            super(num, nom, proprietaire, prixAchat, prixLoyer);
            this.groupe = groupe;
            
            
        }

        @Override
	public Message action(Joueur aJ, int sommeLances, String choix) {
            Message mess = new Message();
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
    
    
    /**
     * @return the groupe
     */
    public Groupe getGroupe() {
        return groupe;
    }
    
    @Override
    public boolean acheterPropriete(Joueur j){
        if(j.getCash() >= this.getPrixAchat()){
            this.setProprietaire(j);
            j.diminuerCash(this.getPrixAchat());
            j.addProprieteAConstruire(this);
            return true;
        }
        else{
            return false;
        }

    }
    
    @Override
    public int calculLoyer(int sommeLances) {
        int l = super.getPrixLoyer();
        Groupe g = this.getGroupe();
        Joueur j = super.getProprietaire();
        int nb = 0; //représente le nombre de propriétés du groupe (en fonction de la couleur) que posséde le propriétaire

        for (ProprieteAConstruire i : j.getPropietes_a_construire()){
            if (i.getGroupe().getCouleur().equals(this.getGroupe().getCouleur())){
                nb++;
            }
        }

        if (nb == this.getGroupe().getNbProprietes()) {
            return (l * 2);
        }
        else{
            return (l);
        }
  }
          
}