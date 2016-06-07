package Ui;

import Jeu.*;


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;



public class IHM_Jeu extends JFrame{
	private Controleur controleur;
        
        private JButton but_LancerDes;
        private JButton but_FinTour;
        private JButton but_Demarrer;
        private JButton but_Quitter;
        
        
        private JPanel pan_joueur;
        private JPanel pan_center;
        private JPanel pan_east;
        private JPanel pan_CN;
        
        private HashMap<Integer,Joueur> joueurs;
        
        private JLabel lab_imageDe1;
        private JLabel lab_imageDe2;
        
        private ImageIcon[] images;
        
        private Joueur joueurCourant;
        
        
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
            
            joueurCourant = new Joueur(null, null);
            
            pan_center = new JPanel();
            pan_east = new JPanel();
             joueurs = controleur.getMonopoly().getJoueurs();
            
            // Boutons
                but_LancerDes = new JButton("Lancer dés");
                but_LancerDes.setMaximumSize(new Dimension(Integer.MAX_VALUE, but_LancerDes.getMinimumSize().height+10));
                but_LancerDes.addActionListener((ActionEvent e) -> {
                    controleur.jouerUnCoup(controleur.getMonopoly().getJoueurs().get(1)); //a modifier
                });

                but_FinTour = new JButton("Fin du tour");
                but_FinTour.setMaximumSize(new Dimension(Integer.MAX_VALUE, but_FinTour.getMinimumSize().height+10));

                but_Demarrer = new JButton("Démarrer");
                but_Demarrer.setMaximumSize(new Dimension(Integer.MAX_VALUE, but_Demarrer.getMinimumSize().height+10));

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

                pan_EC.add(but_LancerDes);
                pan_EC.add(but_FinTour);

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
                pan_CN.setLayout(new GridLayout(2,2));

                 pan_CN.setBorder(new TitledBorder(new LineBorder(Color.black, 3),"Informations sur les joueurs:"));

                //Panel joueurs :
                for (HashMap.Entry<Integer,Joueur> e : joueurs.entrySet()) {
                    pan_joueur = new JPanel(new GridLayout(2,1));
                    pan_joueur.setBorder(new TitledBorder(new LineBorder(Color.RED, 1),e.getValue().getNom()));
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
        
        
        public void display(Controleur controleur){
            
        // Gestion des dés
            switch (controleur.getDe1()){ //de1
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

        
            switch (controleur.getDe2()){ //de2
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
            pan_CN.removeAll();
            pan_joueur.removeAll();
            for (HashMap.Entry<Integer,Joueur> e : joueurs.entrySet()) {
                    pan_joueur = new JPanel(new GridLayout(2,1));
                    if (e==joueurCourant){
                        pan_joueur.setBorder(new TitledBorder(new LineBorder(Color.RED, 1),e.getValue().getNom()));
                    } else{
                        pan_joueur.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1),e.getValue().getNom()));
                    }
                    pan_joueur.add(new JLabel("Case actuelle : "));
                    pan_joueur.add( new JLabel ( e.getValue().getPosCourante().getNomCarreau() + "(" + e.getValue().getPosCourante().getNumero() + ")" ));
                    pan_joueur.add(new JLabel("Argent : "));
                    pan_joueur.add(new JLabel(Integer.toString(e.getValue().getCash())));
                    pan_CN.add(pan_joueur);
            }         
            pan_joueur.repaint();

            


            
        }
        
        

        
        
        public void infoJoueur(Joueur aJ, Controleur c){
            joueurCourant = aJ;
            this.display(c);
            //System.out.println("Position = " + aJ.getPosCourante().getNumero() + " " + de1 + "et" + de2 + " : " + aJ.getNom() + " - >  " + aJ.getPosCourante().getNomCarreau());
        }
        
        public void joueurSupprime(String nom){
            System.err.println("Le joueur " + nom + " supprimé !");
        }
        
        public void joueurAGagne(String nom){
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
        
        public void achatEffectue(int cash, Controleur c){
            JOptionPane.showMessageDialog(this, "Achat effectué.\n" + "Argent total apres = " + cash);
            this.display(c);
//            System.out.println("Achat effectué ! ");
//            System.out.println("Argent total apres = " + cash);
        }
        
        public void passer(){
            JOptionPane.showMessageDialog(this, "Achat refusé.");
            //System.out.println("Achat refusé");
        }
        
        public Joueur creerJoueur() {
            Scanner sc = new Scanner(System.in);
            String rep = sc.nextLine();
            Joueur j = new Joueur(rep, controleur.getMonopoly().getCarreau(1));
            return j;
        }
        

        
        
}