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
public class CaisseDeCommunaute extends AutreCarreau {
    private CartesCaisseDeCommunaute carte;
    
    public CaisseDeCommunaute(int num, String nom){
        super(num, nom);
        this.carte = new CartesCaisseDeCommunaute(nom, num);
        
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
                        //aJ.setCarreau();
                        aJ.allerEnPrison();
                        mess.type = Message.Types.CARTE_ALLEZ_PRISON;
                        break;
                    case "DE":
                        mess.type = Message.Types.CARTE_DEPART;  
                        break;
                    case "BE" :
                        mess.type = Message.Types.CARTE_BELLEVILLE;
                        break;
                    case "LI":
                        //aJ.carteLiberePrison();
                        mess.type = Message.Types.CARTE_LIBERE_PRISON;
                        break;
                    case "GA":
                        aJ.encaisserGain(carte.getPrix());
                        mess.type = Message.Types.CARTE_GAIN;
                        break;
            };
            return mess;
    }
}
