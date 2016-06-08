package Jeu;

import Data.Message;
import Data.Observateur;
import Ui.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;

public class Controleur {
	private IHM_CreationJoueurs ihmJoueurs;
        private IHM_Jeu ihm;
	private Monopoly monopoly;
        private int de1;
        private int de2;
        private Observateur observateur;
        
        
        public Controleur() {
            this.monopoly = new Monopoly();
            this.ihmJoueurs = new IHM_CreationJoueurs(this);
            this.ihm = new IHM_Jeu(this);
            this.de1 = 0;
            this.de2 = 0;
            ihmJoueurs.afficher();
        }
        
        
        

	public void jouerUnCoup(Joueur aJ) {
            
            Message message = new Message();
            String choix;
            int nbdoubles = 0;
            Carreau c = this.lancerDesAvancer(aJ);
            
            
            
            while(de1 == de2){
                lancerDesAvancer(aJ);
                if (nbdoubles == 2){
                    aJ.setCarreau(monopoly.getCarreau(11));
                }
                nbdoubles++;
            }
            
            getIhmJeu().infoJoueur(aJ, this); // position, cash, somme lancés etc...
            
            if (c instanceof Gare){
               Joueur jProprio = ((Gare) c).getProprietaire();
               if (jProprio == null){
                   choix = getIhmJeu().choixPayer( aJ.getPosCourante(), ((Gare) c).getPrixAchat() ); //payer ? (y/n)
                   message = ((Gare) c).action(aJ,(this.de1 + this.de2), choix); //si y , message.type = ACHAT, sinon message.type = PASSER
               }
               if (jProprio != null && jProprio != aJ) {
                   int l = ((Gare) c).calculLoyer(0);
                   aJ.payerLoyer(l);
                   jProprio.recevoirLoyer(l);
               }
            }   
            
            if (c instanceof Compagnie){
               Joueur jProprio = ((Compagnie) c).getProprietaire();
               if (jProprio == null){
                   choix = getIhmJeu().choixPayer( aJ.getPosCourante(), ((Compagnie) c).getPrixAchat() );
                   message = ((Compagnie) c).action(aJ,(this.de1 + this.de2), choix);
               }
               if (jProprio != null && jProprio != aJ) {
                   int l = ((Compagnie) c).calculLoyer(0);
                   aJ.payerLoyer(l);
                   jProprio.recevoirLoyer(l);
               }
            }
 
            if (c instanceof ProprieteAConstruire){
               Joueur jProprio = ((ProprieteAConstruire) c).getProprietaire();
               if (jProprio == null){
                   choix = getIhmJeu().choixPayer( aJ.getPosCourante(), ((ProprieteAConstruire) c).getPrixAchat() );
                   message = ((ProprieteAConstruire) c).action(aJ,(this.de1 + this.de2), choix);
               }
               
               if (jProprio != null && !jProprio.getNom().equals(aJ.getNom())) {
                   int l = ((ProprieteAConstruire) c).calculLoyer(0);
                   aJ.payerLoyer(l);
                   jProprio.recevoirLoyer(l);
               }
               
               if (jProprio.getNom().equals(aJ.getNom())){
                   choix = getIhmJeu().choixPayer( aJ.getPosCourante(), ((ProprieteAConstruire) c).getPrixAchat() );
               }
               
            }
               
            if (message.type == Message.Types.ACHAT_PROPRIETE) {
                getIhmJeu().achatEffectue(aJ.getCash(), this);
            }
            else if (message.type == Message.Types.PASSER) {
                getIhmJeu().passer();
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
                        getIhmJeu().joueurSupprime(entry.getValue().getNom());
                    }



                    while (de1 == de2){
                        jouerUnCoup(j);
                    }
                    
                }
            }
            
            getIhmJeu().joueurAGagne(joueurs.get(numJoueurGagnant).getNom());
        }

	private Carreau lancerDesAvancer(Joueur aJ) {

                       int d = lancerDes();

                
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

    /**
     * @return the observateur
     */
    public Observateur getObservateur() {
        return observateur;
    }

    /**
     * @param observateur the observateur to set
     */
    public void setObservateur(Observateur observateur) {
        this.observateur = observateur;
    }

    /**
     * @param monopoly the monopoly to set
     */
    public void setMonopoly(Monopoly monopoly) {
        this.monopoly = monopoly;
    }

    /**
     * @return the ihm
     */
    public IHM_Jeu getIhmJeu() {
        return ihm;
    }


}
