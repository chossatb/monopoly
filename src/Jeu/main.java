/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;
import Ui.*;

/**
 *
 * @author touronl
 */
public class main {
    
    public static void main (String[] args){
        
        Controleur c = new Controleur();
        c.getMonopoly().CreerPlateau("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Data/data.txt",
                                     "/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Data/data.txt", 
                                     "/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Data/data.txt");
        IHM_CreationJoueurs ihm = new IHM_CreationJoueurs(c);
        

        
  

       
       // c.jouerPlusieursTours(c.getMonopoly().getJoueurs());
       
        
        
        

    
    
    }
    
    
    
}
