package Jeu;

import Ui.*;
import java.math.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;

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
            
            ihm.infoJoueur(aJ, de1, de2);
            
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
            int numJoueurGagnant=0;
            int nbJoueurs = joueurs.size();
            while (joueurs.size()>1) {
                Iterator<Map.Entry<Integer,Joueur>> iter = joueurs.entrySet().iterator();
                while (iter.hasNext()){          
                    Map.Entry<Integer, Joueur> entry = iter.next();
                   
                    if (nbJoueurs == 1){
                        numJoueurGagnant = entry.getKey();
                        break;
                    }
                    Integer i = entry.getKey();
                    Joueur j = entry.getValue();
                    jouerUnCoup(j);
                    if (entry.getValue().getCash() <= 0) {
                        entry.getValue().reinitProprietes();
                        iter.remove();
                        nbJoueurs = nbJoueurs - 1;
                        ihm.joueurSupprime(entry.getValue().getNom());
                    }



                    while (de1 == de2){
                        jouerUnCoup(j);
                    }
                    
                }
            }
            
            ihm.joueurAGagne(joueurs.get(numJoueurGagnant).getNom());
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
                if( (num+aD)>40 ) {
                    num = num+aD-40;
                } else {
                    num = num+aD;
                }
                return getMonopoly().getCarreau(num);
                
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

    /**
     * @return the monopoly
     */
    public Monopoly getMonopoly() {
        return monopoly;
    }


}
