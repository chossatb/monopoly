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
            if(carte.getType().equals("AM")){
                aJ.diminuerCash(carte.getPrix());
                mess.type = Message.Types.CARTE_AMENDE;
                return mess;
            }else if(carte.getType().equals("PR")){
                aJ.setCarreau();
                aJ.allerEnPrison();
//                mess = null;
                return mess;
            }else if(carte.getType().equals("DE")){
                mess.type = Message.Types.CARTE_DEPLACEMENT;
                return mess;
            }else if(carte.getType().equals("LI")){
//                aJ.carteLiberePrison();
                return mess;
            }else if(carte.getType().equals("GA")){
                aJ.encaisserGain(carte.getPrix());
                return mess;
            }else if(carte.getType().equals("RE")){
                aJ.getPosCourante();
              return mess;
            }else{
                int coutMaison = carte.getPrixParMaison();
                int coutHotel = carte.getPrixParHotel();
                aJ.diminuerCash(coutMaison*aJ.getNbMaison()+coutHotel*aJ.getNbHotel());
                mess.type = Message.Types.CARTE_MAISON_HOTEL;
                return mess;
            }
    }

    
}
