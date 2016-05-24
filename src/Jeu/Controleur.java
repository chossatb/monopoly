package Jeu;

import Ui.*;
import java.math.*;

public class Controleur {
	public IHM ihm;
	public Monopoly monopoly;

	public void jouerUnCoup(Joueur aJ) {
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
		int de1 = (int)(Math.random() * (max-min)) + min;
                int de2 = (int)(Math.random() * (max-min)) + min;
                return de1 + de2;

	}

	private Carreau setNouveauCarreau(int aD, Carreau cCour) {
		int num = cCour.getNumero();
                num =+ aD;
                cCour = monopoly.getCarreau(num);
                return cCour;
	}


}