package Jeu;

import Ui.*;
import java.math.*;
import java.util.HashMap;

public class Controleur {
	private IHM ihm;
	private Monopoly monopoly;
        private int de1;
        private int de2;

	public void jouerUnCoup(Joueur aJ) {
            Carreau c = this.lancerDesAvancer(aJ);
            if (c instanceof Gare){
                ((Gare) c).action(aJ,(this.de1 + this.de2));
            }
            if (c instanceof Compagnie){
                ((Compagnie) c).action(aJ,(this.de1 + this.de2));
            }
            if (c instanceof ProprieteAConstruire){
               ((ProprieteAConstruire) c).action(aJ,(this.de1 + this.de2));
            }
	}
        
        public void jouerPlusieursTours(HashMap<Integer, Joueur> Joueurs){
            for(Joueur j : Joueurs.values()){
                jouerUnCoup(j);
                while (de1 == de2){
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
        

	private int lancerDes() {
                int min = 1;
                int max = 7;
                this.setDe1((int)(Math.random() * (max-min)) + min);
                this.setDe2((int)(Math.random() * (max-min)) + min);
                return getDe1() + getDe2();
	}

	private Carreau setNouveauCarreau(int aD, Carreau cCour) {
		int num = cCour.getNumero();
                num =+ aD;
                cCour = monopoly.getCarreau(num);
                return cCour;
	}

    /**
     * @return the de1
     */
    public int getDe1() {
        return de1;
    }

    /**
     * @param de1 the de1 to set
     */
    public void setDe1(int de1) {
        this.de1 = de1;
    }

    /**
     * @return the de2
     */
    public int getDe2() {
        return de2;
    }

    /**
     * @param de2 the de2 to set
     */
    public void setDe2(int de2) {
        this.de2 = de2;
    }


}
