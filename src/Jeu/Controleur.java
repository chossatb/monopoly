package Jeu;

import Ui.*;
import java.math.*;
import java.util.HashMap;
import java.util.Map;

public class Controleur {
	private IHM ihm;
	private Monopoly monopoly;
        private int de1;
        private int de2;
        
        
        public Controleur(IHM ihm, Monopoly monopoly) {
            this.ihm = ihm;
            this.monopoly = monopoly;
            this.de1 = 0;
            this.de2 = 0;
        }
        

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
        
        public void jouerPlusieursTours(HashMap<Integer, Joueur> joueurs){
            for(Map.Entry<Integer, Joueur> entry : joueurs.entrySet()){        
                Integer i = entry.getKey();
                Joueur j = entry.getValue();
                jouerUnCoup(j);
                while (de1 == de2){
                    jouerUnCoup(j);
                }
                if (i.equals(joueurs.size()-1)){//si c'est le tour du dernier joueur de la hashmap
                    i = 0;
                    j = joueurs.get(0);//recommencer au premier joueur
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
                num = num + aD;
                return monopoly.getCarreau(num);
                
                //Out of bounds exception
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
