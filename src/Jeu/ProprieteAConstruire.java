package Jeu;

public class ProprieteAConstruire extends Propriete{
    
    private Groupe groupe;
    
    public ProprieteAConstruire (int num, String nom, Joueur proprietaire, int prixAchat, int prixLoyer, Groupe groupe){
        
            super(num, nom, proprietaire, prixAchat, prixLoyer);
            this.groupe = groupe;
            
        }

            @Override
	public Propriete action(Joueur aJ, int sommeLances) {
               Joueur jProprio = this.getProprietaire();
               if (jProprio == null){
                   this.acheterPropriete(aJ);   
               }
               else if (jProprio != aJ) {
                   int l = this.calculLoyer(0);
                   aJ.payerLoyer(l);
                   jProprio.recevoirLoyer(l);
               }
               return this;
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
              return null;
          }
}