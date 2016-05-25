package Jeu;



public class Groupe {
	private CouleurPropriete couleur;
        
        public Groupe (CouleurPropriete couleur){
            this.couleur = couleur;
        }
        
        public String getCouleur(){
            return(this.couleur.toString());
        }
        
        public void setCouleur(CouleurPropriete couleur){
            this.couleur=couleur;
        }
        
        
}