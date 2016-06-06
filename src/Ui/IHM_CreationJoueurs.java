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



public class IHM_CreationJoueurs extends JFrame{
    
	private Controleur controleur;
        
        private JTextField champ_1;
        private JTextField champ_2;
        private JTextField champ_3;
        private JTextField champ_4;
        private JTextField champ_5;
        private JTextField champ_6;
        
        
        
        public IHM_CreationJoueurs(Controleur c){
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
        //Titre fenetre
            JPanel pan_joueurs = new JPanel(new GridLayout(6,2));
            pan_joueurs.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1),"Création des joueurs"));
            

            
        //joueur 1 :
            pan_joueurs.add(new JLabel("Joueur 1 : "));
            champ_1 = new JTextField();
            pan_joueurs.add(champ_1);
            
        //joueur 2 : 
            pan_joueurs.add(new JLabel("Joueur 2 : "));
            champ_2 = new JTextField();
            pan_joueurs.add(champ_2);
            
        //joueur 3 : 
            pan_joueurs.add(new JLabel("Joueur 3 : "));
            champ_3 = new JTextField();
            pan_joueurs.add(champ_3);
            
        //joueur 4 : 
            pan_joueurs.add(new JLabel("Joueur 4 : "));
            champ_4 = new JTextField();
            pan_joueurs.add(champ_4);
            
        //joueur 5 : 
            pan_joueurs.add(new JLabel("Joueur 5 : "));
            champ_5 = new JTextField();
            pan_joueurs.add(champ_5);
            
        //joueur 6 : 
            pan_joueurs.add(new JLabel("Joueur 6 : "));
            champ_6 = new JTextField();
            pan_joueurs.add(champ_6);
            
            this.add(pan_joueurs, BorderLayout.CENTER);
            
            
        //Boutton Valider
            JButton but_valider = new JButton("Valider");
            this.add(but_valider, BorderLayout.SOUTH);
            
        //Détection clic valider :
            but_valider.addActionListener((ActionEvent e) -> {

                majJoueurDepuisIhm();
            });

        
        }
        
    
    public void majJoueurDepuisIhm(){
        int compteur = 0;
        
        HashMap<Integer, Joueur> joueurs = new HashMap<>();
    
        if (!champ_1.getText().equals("")){
            joueurs.put(compteur, new Joueur(champ_1.getText(), controleur.getMonopoly().getCarreau(1)));
            compteur++;
        }
        
        if (!champ_2.getText().equals("")){
            joueurs.put(compteur, new Joueur(champ_2.getText(), controleur.getMonopoly().getCarreau(1)));
            compteur++;
        }
        
        if (!champ_3.getText().equals("")){
            joueurs.put(compteur, new Joueur(champ_3.getText(), controleur.getMonopoly().getCarreau(1)));
            compteur++;
        }
        
        if (!champ_4.getText().equals("")){
            joueurs.put(compteur, new Joueur(champ_4.getText(), controleur.getMonopoly().getCarreau(1)));
            compteur++;
        }
        
        if (!champ_5.getText().equals("")){
            joueurs.put(compteur, new Joueur(champ_5.getText(), controleur.getMonopoly().getCarreau(1)));
            compteur++;
        }
        
        if (!champ_6.getText().equals("")){
            joueurs.put(compteur, new Joueur(champ_6.getText(), controleur.getMonopoly().getCarreau(1)));
            compteur++;
        }
        
        
        if (compteur < 2) {
            JOptionPane.showMessageDialog(this, "Il doit y avoir au moins deux joueurs ! ");
            this.repaint();
            
        }else{
            controleur.getMonopoly().creerJoueurs(joueurs);
            this.setVisible(false);
            controleur.getIhmJeu().afficher();
            
        }
        
        
    }
        
        
    
        
}