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
        
        return null;
    }
}
