package Jeu;

import java.util.ArrayList;


public class Groupe {
	private CouleurPropriete couleur;
        private ArrayList<ProprieteAConstruire> proprietes;
        
        public Groupe (CouleurPropriete couleur){
            this.couleur = couleur;
            this.proprietes = new ArrayList<ProprieteAConstruire>();
        }
        
        public String getCouleur(){
            return(this.couleur.toString());
        }
        
        public void setCouleur(CouleurPropriete couleur){
            this.couleur=couleur;
        }
        
        public int getNbProprietes() {
            return (this.proprietes.size());
        }
        
}