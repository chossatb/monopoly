/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

import Data.Message;

/**
 *
 * @author guinatha
 */
public class Chance extends AutreCarreau {
        private CartesChance carte;
        
    public Chance(int num, String nom){
        super(num, nom);
        this.carte = new CartesChance(nom, num);
        
    }
    
    public void tirerCarte(){
        carte.getNom();
        carte.getNum();
        carte.getType();
    }
    
    @Override
    public Message action(Joueur aJ, int sommeLances, String choix){
        Message mess = new Message();
        switch (carte.getType()){
                    case "AM":
                        aJ.diminuerCash(carte.getPrix());
                        mess.type = Message.Types.CARTE_AMENDE; 
                        break;
                    case "PR":
                        mess.type = Message.Types.CARTE_ALLEZ_PRISON;  
                        break;
                    case "DE":
                        mess.type = Message.Types.CARTE_DEPART;
                        break;
                    case "HM":
                        mess.type = Message.Types.CARTE_AVENUE_HENRI_MARTIN;
                        break;
                    case "GL":
                        mess.type = Message.Types.CARTE_GARE_DE_LYON;
                        break;
                    case "BV":
                        mess.type = Message.Types.CARTE_BOULEVARD_DE_LA_VILETTE;
                        break;
                    case "RP":
                        mess.type = Message.Types.CARTE_RUE_DE_LA_PAIX;
                        break;
                    case "LI":
                        //aJ.carteLiberePrison();
                        aJ.isCartePrison();
                        mess.type = Message.Types.CARTE_LIBERE_PRISON;
                        break;
                    case "GA":
                        aJ.encaisserGain(carte.getPrix());
                        mess.type = Message.Types.CARTE_GAIN;
                        break;
                    case "RE"://Reculer de 3 cases
                        //aJ.getPosCourante();
                        mess.type = Message.Types.CARTE_RECULER;
                        break;
                    case "MH":
                        int coutMaison = carte.getPrixParMaison();
                        int coutHotel = carte.getPrixParHotel();
                        aJ.diminuerCash(coutMaison*aJ.getNbMaison()+coutHotel*aJ.getNbHotel());
                        mess.type = Message.Types.CARTE_MAISON_HOTEL;
                        break;
            };
            return mess;
    }

    
}
