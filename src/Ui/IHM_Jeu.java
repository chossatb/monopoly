package Ui;

import Jeu.*;


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;



public class IHM_Jeu extends JFrame{
	private Controleur controleur;
        

        private JButton but_Demarrer;
        private JButton but_Quitter;
        
        
        private JPanel pan_joueur;
        private JPanel pan_center;
        private JPanel pan_east;
        private JPanel pan_CN;
        
        private HashMap<Integer,Joueur> joueurs;
        
        private JLabel lab_imageDe1;
        private JLabel lab_imageDe2;
        private JLabel[] tab_caseActuelle;
        private JLabel[] tab_argent;
        private TitledBorder[] tab_nomJ;
        
        private ImageIcon[] images;
        
        private Joueur joueurCourant;
        
        
        public IHM_Jeu(Controleur c){
            this.controleur= c;
        }
        
        public void afficher() {
            initUiComponents(); 
            setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            this.setTitle("Monopoly");
            setSize(1500, 750);
            setVisible(true);                        
        }
        
        public void initUiComponents(){
            
            this.setLayout(new BorderLayout());
            
            joueurCourant = new Joueur(null, null);
            
            pan_center = new JPanel();
            pan_east = new JPanel();
            joueurs = controleur.getMonopoly().getJoueurs();
            
            // Boutons


                but_Demarrer = new JButton("Démarrer");
                but_Demarrer.setMaximumSize(new Dimension(Integer.MAX_VALUE, but_Demarrer.getMinimumSize().height+10));
                but_Demarrer.addActionListener((ActionEvent e) -> {
                    controleur.jouerPlusieursTours(joueurs);
                });

                but_Quitter = new JButton("Quitter");
                but_Quitter.setMaximumSize(new Dimension(Integer.MAX_VALUE, but_Quitter.getMinimumSize().height+10));
                but_Quitter.addActionListener((ActionEvent e) -> {
                    System.exit(0);
                });
                
            // Gestion de l'image monopoly
                ImageIcon image = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/monopoly.jpg");
                JLabel lab_image = new JLabel(image);
            
            // Gestion des images dés   
                images = new ImageIcon[7];
                images[0] = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de0.jpg");
                images[1] = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de1.jpg");
                images[2] = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de2.jpg");
                images[3] = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de3.jpg");
                images[4] = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de4.jpg");
                images[5] = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de5.jpg");
                images[6] = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de6.jpg");           

                lab_imageDe1 = new JLabel(images[0]);
                lab_imageDe2 = new JLabel(images[0]);
            
                
                
                
            
            /////////////PLACEMENT//////////////////////////////////////////////////////////////////////////////////////////////////

            //EAST//////////////////////////////////////////////////
                JPanel pan_EN = new JPanel();
                pan_EN.setLayout(new BoxLayout(pan_EN, BoxLayout.PAGE_AXIS));

                JPanel pan_de = new JPanel();
                pan_de.setLayout(new BorderLayout());
                pan_de.setBackground(Color.LIGHT_GRAY);
                pan_de.add(lab_imageDe1, BorderLayout.WEST);
                pan_de.add(lab_imageDe2, BorderLayout.EAST);

                pan_EN.add(pan_de);

                JPanel pan_EC = new JPanel();
                pan_EC.setLayout(new BoxLayout(pan_EC, BoxLayout.PAGE_AXIS));
                pan_EC.setBackground(Color.LIGHT_GRAY);



                pan_east.setBackground(Color.LIGHT_GRAY);
                pan_east.setPreferredSize(new Dimension(170, 1000));
                pan_east.setLayout(new BorderLayout());

                pan_east.add(pan_EC, BorderLayout.CENTER);

                pan_east.add(pan_EN, BorderLayout.NORTH);

                JPanel pan_ES = new JPanel();
                pan_ES.setLayout(new BoxLayout(pan_ES, BoxLayout.PAGE_AXIS));
                pan_ES.add(but_Demarrer);
                pan_ES.add(but_Quitter);

                pan_east.add(pan_ES, BorderLayout.SOUTH);

                this.add(pan_east, BorderLayout.EAST);
            
            //CENTER//////////////////////////////////////////////////
                pan_CN = new JPanel();
                pan_CN.setLayout(new GridLayout(6,1));

                 pan_CN.setBorder(new TitledBorder(new LineBorder(Color.black, 3),"Informations sur les joueurs:"));
                 
                 pan_CN.setPreferredSize(new Dimension(600, 700));
                 
                 tab_argent = new JLabel[controleur.getMonopoly().getJoueurs().size()];
                 tab_caseActuelle = new JLabel[controleur.getMonopoly().getJoueurs().size()];
                 tab_nomJ = new TitledBorder[controleur.getMonopoly().getJoueurs().size()];
                 
                 //Initialisation des Labels info_joueurs
                 for (int i = 0 ; i < controleur.getMonopoly().getJoueurs().size(); i++){
                     tab_argent[i] = new JLabel();
                     tab_caseActuelle[i] = new JLabel();
                     tab_nomJ[i] = new TitledBorder(new LineBorder(Color.GRAY, 1));
                     pan_joueur = new JPanel(new GridLayout(2,1));
                     pan_joueur.setBorder(tab_nomJ[i]);
                     pan_joueur.add(new JLabel("Case actuelle : "));
                     pan_joueur.add(tab_caseActuelle[i]);
                     pan_joueur.add(new JLabel("Argent : "));
                     pan_joueur.add(tab_argent[i]);
                     pan_CN.add(pan_joueur);
                 }
                 
                 
                 
                 //Affectation des Labels en fonction des informations des joueurs (uniquement pour le premier affichage de l'interface).
                 int i =0;
                 for (HashMap.Entry<Integer,Joueur> e : joueurs.entrySet()) {
                     if (e.getValue().getNom().equals(joueurCourant.getNom())){
                        tab_nomJ[i].setTitleColor(Color.red);
                     } else{
                        tab_nomJ[i].setTitleColor(Color.gray);
                     }
                     tab_nomJ[i].setTitle(e.getValue().getNom());
                     tab_caseActuelle[i].setText(e.getValue().getPosCourante().getNomCarreau() + "(" + e.getValue().getPosCourante().getNumero() + ")");
                     tab_argent[i].setText(Integer.toString(e.getValue().getCash()));
                     i++;
                 }


                this.pan_center.add(pan_CN, BorderLayout.WEST);
                this.pan_center.add( lab_image, BorderLayout.EAST);

                this.add(pan_center, BorderLayout.CENTER);

        }
        
        
        public void display(Controleur c){
            
        // Gestion des dés
            switch (c.getDe1()){ //de1
                    case 0:
                        lab_imageDe1.setIcon(images[0]);  
                        break;
                    case 1:
                        lab_imageDe1.setIcon(images[1]);  
                        break;
                    case 2:
                        lab_imageDe1.setIcon(images[2]);  
                        break;
                    case 3:
                        lab_imageDe1.setIcon(images[3]);  
                        break;
                    case 4:
                        lab_imageDe1.setIcon(images[4]);  
                        break;
                    case 5:
                        lab_imageDe1.setIcon(images[5]);  
                        break;
                    case 6:
                        lab_imageDe1.setIcon(images[6]);  
                        break;
            };

        
            switch (c.getDe2()){ //de2
                    case 0:
                        lab_imageDe2.setIcon(images[0]);  
                        break;
                    case 1:
                        lab_imageDe2.setIcon(images[1]);  
                        break;
                    case 2:
                        lab_imageDe2.setIcon(images[2]);  
                        break;
                    case 3:
                        lab_imageDe2.setIcon(images[3]);  
                        break;
                    case 4:
                        lab_imageDe2.setIcon(images[4]);  
                        break;
                    case 5:
                        lab_imageDe2.setIcon(images[5]);  
                        break;
                    case 6:
                        lab_imageDe2.setIcon(images[6]);  
                        break;
            };
            
            
        //MAJ Panel Joueurs
            int i =0;
            
                joueurs.remove(joueurs);
            
                 for (HashMap.Entry<Integer,Joueur> e : c.getMonopoly().getJoueurs().entrySet()) {
                     
                     if (e.getValue().getNom().equals(joueurCourant.getNom())){
                        tab_nomJ[i].setTitleColor(Color.red);
                     } else{
                        tab_nomJ[i].setTitleColor(Color.gray);
                     }
                     tab_caseActuelle[i].setText(e.getValue().getPosCourante().getNomCarreau() + "(" + e.getValue().getPosCourante().getNumero() + ")");
                     tab_argent[i].setText(Integer.toString(e.getValue().getCash()));
                     i++;
                 }
                 
                 joueurs.putAll(c.getMonopoly().getJoueurs());
                 
                 pan_CN.repaint();
                 

    
        }
        
        

        
        public void infoJoueur(Joueur aJ, Controleur c){
            joueurCourant = aJ;
            this.display(c);
        }
        
        public void joueurSupprime(String nom){ 
            JOptionPane.showMessageDialog(this, "Le joueur " + nom + " a perdu.");    
            System.err.println("Le joueur " + nom + " supprimé !");
        }
        
        public void joueurAGagne(String nom){
            but_Demarrer.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Le joueur " + nom + " a gagné.");
            System.out.println("Le joueur " + nom + " a gagné !");
        }
        
        public String choixPayer(Carreau carreau,int prix){  
            int n = JOptionPane.showConfirmDialog(this,"Vous êtes sur la case " + carreau.getNomCarreau() + ".\n" + "Voulez vous acheter la case ? (Prix = " + prix + ")","Achat",JOptionPane.YES_NO_OPTION);
            if (n == 0){
                return "y";
            }
            else {
                return "n";
            }

        }
        
        public String choixMaison(Joueur aJ, Carreau carreau){  
            int n = JOptionPane.showConfirmDialog(this,"Vous êtes sur la case " + carreau.getNomCarreau() + ".\n" + "Voulez vous acheter une maison ?","Achat",JOptionPane.YES_NO_OPTION);
            if (n == 0){
                IHM_achat_maison ihmachat = new IHM_achat_maison(aJ, controleur);
                return "y";
            }
            else {
                return "n";
            }

        }
        
        public void achatEffectue(int cash, Controleur c){
            JOptionPane.showMessageDialog(this, "Achat effectué.\n" + "Argent total apres = " + cash);
            this.display(c);
        }
        
        public void passer(){
            JOptionPane.showMessageDialog(this, "Achat refusé.");
        }

        

        
        
}