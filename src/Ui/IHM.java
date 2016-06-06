package Ui;

import Jeu.*;


import java.util.*;
import javax.swing.*;
import java.awt.*;



public class IHM extends JFrame{
	private Controleur controleur;
        
        private JButton but_LancerDes;
        private JButton but_Acheter;
        private JButton but_FinTour;
        private JButton but_Demarrer;
        private JButton but_Quitter;
        
        
        JPanel pan_center;
        JPanel pan_east;
        
        
        public IHM(Monopoly monopoly){
            this.controleur= new Controleur(this, monopoly);
            
        }
        
        public void afficher() {
            initUiComponents(); 
            setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            setSize(1500, 1000);
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
            
            // Gestion de l'image
            ImageIcon image = new ImageIcon("/users/info/etu-s2/touronl/S2/Projet/Monopoly 1/src/Ui/monopoly.jpg");
            JLabel lab_image = new JLabel(image);
            
            
            
            
            /////////////PLACEMENT//////////////////////////////////////////////////////////////////////////////////////////////////

            //EAST
            JPanel pan_EN = new JPanel();
            pan_EN.setLayout(new BoxLayout(pan_EN, BoxLayout.PAGE_AXIS));
            pan_EN.add(but_LancerDes);
            pan_EN.add(but_Acheter);
            pan_EN.add(but_FinTour);
 
            
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
            
            //CENTER
            this.pan_center.add( lab_image, BorderLayout.CENTER);
            
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
        
        public void creerJoueurs() {
            boolean ok = false;
            int nbj = 0;
            
            while (!ok){
                Scanner sc = new Scanner(System.in);
                System.out.print("Nombre de joueurs : ");
                String rep = sc.nextLine();
                nbj = Integer.parseInt(rep);
                System.out.println("");
                if (nbj < 2){
                    System.out.println("Il faut au moins 2 joueurs !");
                }else if (nbj > 6){
                    System.out.println("Il faut au maximum 6 joueurs !");
                }else{
                    ok = true;
                }
            }
            for (int i = 1; i <= nbj; i++){
                System.out.print("Nom du joueur "+i+" : ");
                Joueur j = creerJoueur();
                controleur.getMonopoly().getJoueurs().put(controleur.getMonopoly().getJoueurs().size(), j);
            }       
        }
        
        
}