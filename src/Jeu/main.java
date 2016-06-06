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
  
        monopoly.creerJoueurs();// faire IHM exte de creerJoueur / creerJoueurs
        
        
       
        c.jouerPlusieursTours(monopoly.getJoueurs());
       
        
        
        

    
    
    }
    
    
    
}
