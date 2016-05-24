package Jeu;



import java.util.ArrayList;
import javax.swing.text.Position;

public class Joueur {
	private String nomJoueur;
	private int cash = 1500;
	public ArrayList<Gare> gares;
        public ArrayList<Compagnie> compagnies;
        public ArrayList<ProprieteAConstruire> propietes_a_construire;
	private Carreau positionCourante;
        
        
        public Joueur(String nom, int cash) {
            nomJoueur = nom;
            this.cash = cash;
            gares = new ArrayList<Gare>();
            compagnies = new ArrayList<Compagnie>();
            propietes_a_construire = new ArrayList<ProprieteAConstruire>();
            //this.positionCourante = new Carreau(0,
        }

	public void payerLoyer(int aL) {
		throw new UnsupportedOperationException();
	}

	public void recevoirLoyer(int aL) {
		throw new UnsupportedOperationException();
	}

	public int getCash() {
		return this.cash;
	}
        
        public void diminuerCash(int val){
            this.cash =- val;
        }

	public Carreau getPosCourante() {
		return positionCourante;
	}

	public void setCarreau(Carreau aCCour) {
		throw new UnsupportedOperationException();
	}
        
        public void addGare(Gare g){
            this.gares.add(g);
        }
        
        public void addCompagnie(Compagnie c){
            this.compagnies.add(c);
        }
        
        public void addProprieteAConstruire(ProprieteAConstruire p){
            this.propietes_a_construire.add(p);
        }
}