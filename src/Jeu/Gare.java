package Jeu;



public class Gare extends Propriete {
        
        public Gare (int num, String nom, Joueur proprietaire, int prixAchat, int prixLoyer){
            super(num, nom, proprietaire, prixAchat, prixLoyer);
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
