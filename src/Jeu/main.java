/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

/**
 *
 * @author touronl
 */
public class main {
    
    public static void main (String[] args){
        
        
        Monopoly monopoly = new Monopoly();
        monopoly.CreerPlateau("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Data/data.txt");
        
        
        Joueur j = new Joueur("Michel");
        monopoly.creerJoueur(j);
        
        Joueur j1 = new Joueur("Michel1");
        monopoly.creerJoueur(j1);
        
        Joueur j2 = new Joueur("Michel2");
        monopoly.creerJoueur(j2);
        
        Joueur j3 = new Joueur("Michel3");
        monopoly.creerJoueur(j3);
        
        Joueur j4 = new Joueur("Michel4");
        monopoly.creerJoueur(j4);
        
        Joueur j5 = new Joueur("Michel5");
        monopoly.creerJoueur(j5);
        
        Joueur j6 = new Joueur("Michel6");
        monopoly.creerJoueur(j6);
                
        monopoly.parcourJoueurs();
        
        
                
        
        
        

    
    
    }
    
    
    
}
