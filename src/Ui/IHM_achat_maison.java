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
        private Joueur j;
        
        
        
        public IHM_achat_maison(Joueur aJ, Controleur c){
            this.controleur= c;    
            this.j = aJ;
            this.afficher();
        }
        
        public void afficher() {
            initUiComponents(); 
            setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            this.setTitle("Monopoly");
            setSize(500, 300);
            setVisible(true);                        
        }
        
        public void initUiComponents(){
            this.setLayout(new BorderLayout());
 
            comb_choix.addItem("Aucune");
            
            for (ProprieteAConstruire p : j.getPropietes_a_construire()) {
                if (p.getNbMaison() != 4){
                    comb_choix.addItem(p.getNomCarreau());
                }
            }
            
            
            JButton but_acheter = new JButton("Acheter");
            but_acheter.addActionListener((ActionEvent e) -> {
                    majJoueurDepuisIhm();
                });
            
            JButton but_annuler = new JButton("Annuler");
            
            this.add(new JLabel("Sur quelle propriété voulez vous acheter la maison ?"), BorderLayout.NORTH);
            this.add(comb_choix, BorderLayout.CENTER);
            JPanel pan_but = new JPanel(new BorderLayout());
            pan_but.add(but_acheter, BorderLayout.EAST);
            pan_but.add(but_annuler, BorderLayout.WEST);
            this.add(pan_but, BorderLayout.SOUTH);
            
        }
        
    
        public void majJoueurDepuisIhm(){
            for (ProprieteAConstruire p : j.getPropietes_a_construire()) {
                if (p.getNomCarreau() == comb_choix.getSelectedItem().toString()) {
                    if (p.getNbMaison() <= 4){
                        p.addMaison();
                    }
                    else if (p.getNbMaison() == 4) {
                        p.addHotel();
                    }
                }
            }
            
        } 
        
}