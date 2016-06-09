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
        private JTextField champs[];
        
        
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
            pan_joueurs.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1),"Création des joueurs (2 joueurs minimum)"));
            
            this.champs = new JTextField[6];
            
            for (int i = 0; i < champs.length; i++){
                pan_joueurs.add(new JLabel("Joueur " + (i+1) + " :"));
                champs[i] = new JTextField();
                pan_joueurs.add(champs[i]);
            }
        
            this.add(pan_joueurs, BorderLayout.CENTER);
            
            
            JPanel pan_but = new JPanel(new GridLayout());    
            
        //Boutton Valider
            JButton but_valider = new JButton("Valider");
            pan_but.add(but_valider);
            
            
        //Bouton quitter
            JButton but_Quitter = new JButton("Quitter");
            pan_but.add(but_Quitter);
            
            this.add(pan_but, BorderLayout.SOUTH);
            
        //Détection clic quitter : 
            but_Quitter.addActionListener((ActionEvent e) -> {
                System.exit(0);
            });
            
        //Détection clic valider :
            but_valider.addActionListener((ActionEvent e) -> {

                majJoueurDepuisIhm();
            });
        }
        
    
    public void majJoueurDepuisIhm(){
        int compteur = 0;
        boolean trouve = false;
        HashMap<Integer, Joueur> joueurs = new HashMap<>();
    
        
        for (int i = 0; i < champs.length; i++){
            if (!champs[i].getText().equals("")){
                if (i == 0){
                    joueurs.put(compteur, new Joueur(champs[i].getText(), controleur.getMonopoly().getCarreau(1)));
                    compteur++;
                }else{
                    Iterator<Map.Entry<Integer,Joueur>> iter = joueurs.entrySet().iterator();
                    while (iter.hasNext()){   
                        Map.Entry<Integer, Joueur> e = iter.next();
                         if (joueurs.size() >= 1 && champs[i].getText().equals(e.getValue().getNom())){

                            trouve = true;
                            break;
                         }
                         else{

                             joueurs.put(compteur, new Joueur(champs[i].getText(), controleur.getMonopoly().getCarreau(1)));
                             compteur++;
                             break;
                         }
                    }
                }
                
            }

        }
        
    
    
        if (trouve){
            JOptionPane.showMessageDialog(this, "Les joueurs doivent avoir des noms différents");
        }else{
            if (compteur < 2) {
                JOptionPane.showMessageDialog(this, "Il doit y avoir au moins deux joueurs");
            }
            else{
                controleur.getMonopoly().creerJoueurs(joueurs);
                this.setVisible(false);
                controleur.getIhmJeu().afficher();
            }
        }
    } 
        
}