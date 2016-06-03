/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;
import Ui.IHM;
import java.util.HashMap;

/**
 *
 * @author touronl
 */
public class main {
    
    public static void main (String[] args){
        
        IHM ihm = new IHM();
        Monopoly monopoly = new Monopoly();
        Controleur c = new Controleur(ihm, monopoly);
        monopoly.CreerPlateau("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Data/data.txt");
  

        
        Joueur j = new Joueur("Michel", monopoly.getCarreau(1));
        monopoly.creerJoueur(j);
        
        Joueur j1 = new Joueur("Michel1", monopoly.getCarreau(1));
        monopoly.creerJoueur(j1);
        
        Joueur j2 = new Joueur("Michel2", monopoly.getCarreau(1));
        monopoly.creerJoueur(j2);
        
        Joueur j3 = new Joueur("Michel3", monopoly.getCarreau(1));
        monopoly.creerJoueur(j3);
        
        Joueur j4 = new Joueur("Michel4", monopoly.getCarreau(1));
        monopoly.creerJoueur(j4);
        
        Joueur j5 = new Joueur("Michel5", monopoly.getCarreau(1));
        monopoly.creerJoueur(j5);
        

//                
//        monopoly.parcourJoueurs();
        
        
 

//        for ( HashMap.Entry<Integer, Joueur> jj : monopoly.getJoueurs().entrySet() ){
//            System.out.println(jj.getValue().getNom() + " : " + jj.getValue().getPosCourante().getNomCarreau());
//        }
        
        c.jouerPlusieursTours(monopoly.getJoueurs());
        
        
        
//        for ( HashMap.Entry<Integer, Joueur> jj : monopoly.getJoueurs().entrySet() ){
//            System.out.println(jj.getValue().getNom() + " " + jj.getValue().getPosCourante().getNomCarreau());
//        }
                      
        
        
        

    
    
    }
    
    
    
}
