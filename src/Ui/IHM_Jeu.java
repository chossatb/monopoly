package Ui;

import Jeu.*;


import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;



public class IHM_Jeu extends JFrame{
	private Controleur controleur;
        
        private JButton but_LancerDes;
        private JButton but_Acheter;
        private JButton but_FinTour;
        private JButton but_Demarrer;
        private JButton but_Quitter;
        
        
        JPanel pan_center;
        JPanel pan_east;
        
        
        public IHM_Jeu(Controleur c){
            this.controleur= c;
        }
        
        public void afficher() {
            initUiComponents(); 
            setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            this.setTitle("Monopoly");
            setSize(1100, 900);
            setVisible(true);                        
        }
        
        public void initUiComponents(){
            this.setLayout(new BorderLayout());
            
            pan_center = new JPanel();
            pan_east = new JPanel();
            
            
            // Boutons
            but_LancerDes = new JButton("Lancer dés");
            but_LancerDes.setMaximumSize(new Dimension(Integer.MAX_VALUE, but_LancerDes.getMinimumSize().height+10));
            
            but_Acheter = new JButton("Acheter");
            but_Acheter.setMaximumSize(new Dimension(Integer.MAX_VALUE, but_Acheter.getMinimumSize().height+10));
            
            but_FinTour = new JButton("Fin du tour");
            but_FinTour.setMaximumSize(new Dimension(Integer.MAX_VALUE, but_FinTour.getMinimumSize().height+10));
            
            but_Demarrer = new JButton("Démarrer");
            but_Demarrer.setMaximumSize(new Dimension(Integer.MAX_VALUE, but_Demarrer.getMinimumSize().height+10));
            
            but_Quitter = new JButton("Quitter");
            but_Quitter.setMaximumSize(new Dimension(Integer.MAX_VALUE, but_Quitter.getMinimumSize().height+10));
            
            // Gestion de l'image monopoly
            ImageIcon image = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/monopoly.jpg");
            JLabel lab_image = new JLabel(image);
            
            // Gestion des images dés
            
            ImageIcon imageDe1;
            JLabel lab_imageDe1;
            
            switch (controleur.getDe1()){
                case 0:
                    imageDe1 = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de0.jpg");
                    lab_imageDe1 = new JLabel(image);
                case 1:
                    imageDe1 = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de1.jpg");
                    lab_imageDe1 = new JLabel(image);
                    break;
                case 2:
                    imageDe1 = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de2.jpg");
                    lab_imageDe1 = new JLabel(image);
                    break;
                case 3:
                    imageDe1 = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de3.jpg");
                    lab_imageDe1 = new JLabel(image);
                    break;
                case 4:
                    imageDe1 = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de4.jpg");
                    lab_imageDe1 = new JLabel(image);
                    break;
                case 5:
                    imageDe1 = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de5.jpg");
                    lab_imageDe1 = new JLabel(image);
                    break;
                case 6:
                    imageDe1 = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de6.jpg");
                    lab_imageDe1 = new JLabel(image);
                    break;
            }
            
            ImageIcon imageDe2;
            JLabel lab_imageDe2;
            
            switch (controleur.getDe2()){
                case 0:
                    imageDe1 = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de0.jpg");
                    lab_imageDe1 = new JLabel(image);
                case 1:
                    imageDe2 = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de1.jpg");
                    lab_imageDe2 = new JLabel(image);
                    break;
                case 2:
                    imageDe2 = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de2.jpg");
                    lab_imageDe2 = new JLabel(image);
                    break;
                case 3:
                    imageDe2 = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de3.jpg");
                    lab_imageDe2 = new JLabel(image);
                    break;
                case 4:
                    imageDe2 = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de4.jpg");
                    lab_imageDe2 = new JLabel(image);
                    break;
                case 5:
                    imageDe2 = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de5.jpg");
                    lab_imageDe2 = new JLabel(image);
                    break;
                case 6:
                    imageDe2 = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/de6.jpg");
                    lab_imageDe2 = new JLabel(image);
                    break;
            }
            

            
            
            
            
            /////////////PLACEMENT//////////////////////////////////////////////////////////////////////////////////////////////////

            //EAST//////////////////////////////////////////////////
            JPanel pan_EN = new JPanel();
            pan_EN.setLayout(new BoxLayout(pan_EN, BoxLayout.PAGE_AXIS));
            pan_EN.add(but_LancerDes);
            pan_EN.add(but_Acheter);
            pan_EN.add(but_FinTour);
            pan_EN.add(lab_imageDe1);
            pan_EN.add(lab_imageDe2);
 
            
            pan_east.setBackground(Color.LIGHT_GRAY);
            pan_east.setPreferredSize(new Dimension(300, 1000));
            pan_east.setLayout(new BorderLayout());
            
            pan_east.add(pan_EN, BorderLayout.NORTH);
            
            JPanel pan_ES = new JPanel();
            pan_ES.setLayout(new BoxLayout(pan_ES, BoxLayout.PAGE_AXIS));
            pan_ES.add(but_Demarrer);
            pan_ES.add(but_Quitter);
            
            pan_east.add(pan_ES, BorderLayout.SOUTH);

            this.add(pan_east, BorderLayout.EAST);
            
            //CENTER//////////////////////////////////////////////////
            JPanel pan_CN = new JPanel();
            pan_CN.setLayout(new GridLayout(2,2));
            
             pan_CN.setBorder(new TitledBorder(new LineBorder(Color.black, 3),"Informations sur les joueurs:"));
            
            //Panel joueurs :
            for (HashMap.Entry<Integer,Joueur> e : controleur.getMonopoly().getJoueurs().entrySet()) {
                JPanel pan_joueur = new JPanel(new GridLayout(2,1));
                pan_joueur.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1),e.getValue().getNom()));
                pan_joueur.add(new JLabel("Case actuelle : "));
                pan_joueur.add( new JLabel ( e.getValue().getPosCourante().getNomCarreau() + "(" + e.getValue().getPosCourante().getNumero() + ")" ));
                pan_joueur.add(new JLabel("Argent : "));
                pan_joueur.add(new JLabel(Integer.toString(e.getValue().getCash())));
                pan_CN.add(pan_joueur);
            }
            

            this.pan_center.add(pan_CN, BorderLayout.NORTH);
            this.pan_center.add( lab_image, BorderLayout.SOUTH);
            
            this.add(pan_center, BorderLayout.CENTER);
            
        }
        
        
        public void infoJoueur(Joueur aJ, int de1, int de2){
            System.out.println("Position = " + aJ.getPosCourante().getNumero() + " " + de1 + "et" + de2 + " : " + aJ.getNom() + " - >  " + aJ.getPosCourante().getNomCarreau());
        }
        
        public void joueurSupprime(String nom){
            System.err.println("Le joueur " + nom + " supprimé !");
        }
        
        public void joueurAGagne(String nom){
            System.out.println("Le joueur " + nom + " a gagné !");
        }
        
        public String choixPayer(int cash,int prix){
            Scanner sc = new Scanner(System.in);
            System.out.println("Argent total avant = " + cash);
            System.out.println("Voulez vous acheter la case ? (y/n)" + " (Prix = " + prix + " )");
            String saisie=sc.nextLine();
            return saisie;
        }
        
        public void achatEffectue(int cash){
            System.out.println("Achat effectué ! ");
            System.out.println("Argent total apres = " + cash);
        }
        
        public void passer(){
            System.out.println("Achat refusé");
        }
        
        public Joueur creerJoueur() {
            Scanner sc = new Scanner(System.in);
            String rep = sc.nextLine();
            Joueur j = new Joueur(rep, controleur.getMonopoly().getCarreau(1));
            return j;
        }
        

        
        
}