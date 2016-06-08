/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Jeu.*;


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;



public class IHM_achat_maison extends JFrame{
    
	private Controleur controleur;
        private JComboBox comb_choix = new JComboBox();
        
        
        
        public IHM_achat_maison(Controleur c){
            this.controleur= c;            
        }
        
        public void afficher() {
            initUiComponents(); 
            setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            this.setTitle("Monopoly");
            setSize(350, 250);
            setVisible(true);                        
        }
        
        public void initUiComponents(){
            this.setLayout(new BorderLayout());
            this.add(new JLabel("Combien voulez vous acheter de maison ?"), BorderLayout.NORTH);
           
            comb_choix.addItem("Aucune");
           /* for (i = 1; i<controleur.getMonopoly(). ; i++) {
                
            }*/
            
            
            JPanel pan_choix = new JPanel(new GridLayout());
            pan_choix.add(comb_choix);
        }
        
    
    public void majJoueurDepuisIhm(){
        
    } 
        
}