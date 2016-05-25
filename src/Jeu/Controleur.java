package Jeu;

import Ui.*;
import java.math.*;
import java.util.HashMap;

public class Controleur {
	public IHM ihm;
	public Monopoly monopoly;

	public void jouerUnCoup(Joueur aJ) {
            Carreau c = this.lancerDesAvancer(aJ);
            if (c instanceof Gare){
                ((Gare) c).action(aJ, 3);
            }
            if (c instanceof Compagnie){
                
            }
            if (c instanceof ProprieteAConstruire){
                
            }
	}
        
        public void jouerPlusieursTours(HashMap<Integer, Joueur> Joueurs){
            for(Joueur j : Joueurs.values()){
                jouerUnCoup(j);
                while (dbl){
                    jouerUnCoup(j);
                    
                }
        }
        }

	private Carreau lancerDesAvancer(Joueur aJ) {
		int d = this.lancerDes();
                Carreau cCour = aJ.getPosCourante();
                cCour = setNouveauCarreau(d, cCour);
                aJ.setCarreau(cCour);
                return cCour;
                
	}
        private int lancerlesDes(){
                int l1 = lancerDes();
                int l2 = lancerDes();
                return l1 + l2;
        }

	private int lancerDes() {
                int min = 1;
                int max = 7;
		int de1 = (int)(Math.random() * (max-min)) + min;
                return de1;
	}
        
//        private boolean estDouble(){
//            lancerDes();
//            return de1 = de2;
//        }

	private Carreau setNouveauCarreau(int aD, Carreau cCour) {
		int num = cCour.getNumero();
                num =+ aD;
                cCour = monopoly.getCarreau(num);
                return cCour;
	}


}
