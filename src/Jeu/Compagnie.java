package Jeu;

public class Compagnie extends Propriete {
    
    public Compagnie (int num, String nom, Joueur proprietaire, int prixAchat, int prixLoyer){
            super(num, nom, proprietaire, prixAchat, prixLoyer);
        }
    
    
    
        @Override
	public Propriete action(Joueur aJ, int sommeLances) {
               Joueur jProprio = this.getProprietaire();
               if (jProprio == null){
                   this.acheterPropriete(aJ);   
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
    public int calculLoyer(int sommeLances) {
        Joueur j = this.getProprietaire();
        int nbCompagnies = j.getNbCompagnies();
        return nbCompagnies*sommeLances;
    }

}
        
 