package Jeu;


import Data.Message;
import java.util.ArrayList;

public class ProprieteAConstruire extends Propriete{
    
    private Groupe groupe;
    private int[] tab_prixLoyer;
    private int nbMaison;
    private int nbHotel;
    
    public ProprieteAConstruire (int num, String nom, Joueur proprietaire, int prixAchat, int[] tab, Groupe groupe){
        
            super(num, nom, proprietaire, prixAchat, tab[0]);
            tab_prixLoyer = tab;
            this.groupe = groupe;
            nbMaison = 0;
            nbHotel = 0;
            
        }

        @Override
	public Message action(Joueur aJ, int sommeLances, String choix) {
            Message mess = new Message();
            if (choix.equals("y")){ 
                this.acheterPropriete(aJ); 
                mess.type=Message.Types.ACHAT_PROPRIETE;
                return mess;
            } else{
                mess.type=Message.Types.PASSER;
                return mess;
            }

        }
    
    public void construire(){
        if (getNbHotel() == 1){
            //Afficheage popup vous ne pouvez plus construire de maison sur cette propriété
        }else{
            Groupe g = getGroupe();
            Joueur jProprio = this.getProprietaire();
            ArrayList<ProprieteAConstruire> prop_joueur_groupe = new ArrayList<>();

            int nb = 0; // compteur pour connaitre le nb de propriétés possédés par le joueur dans le groupe donné
            for (ProprieteAConstruire i : jProprio.getPropietes_a_construire()){
                if (i.getGroupe().getCouleur().equals(this.getGroupe().getCouleur())){
                    nb++;
                    prop_joueur_groupe.add(i);
                }
            }


            int nbMaisonMin = 100; //représente ne nombre minimum de maison que posséde une propriété dans un groupe  
            ProprieteAConstruire prop_nb_maison_min=null; // contient la propriété qui posséde le mois de maison du groupe
            if (nb == this.getGroupe().getNbProprietes()) { // si le joueur posséde toutes les propriétés du groupe
                for (ProprieteAConstruire p : prop_joueur_groupe){
                    if (this.getNbMaison() < nbMaisonMin){
                        nbMaisonMin = this.getNbMaison();
                        prop_nb_maison_min = p;
                    }
                }

                if (nbMaisonMin == 4){
                    //Affichage voulez vous acheter un hotel ?
                    //oui
                    this.addHotel(); 
                    this.removeMaisons(); //supprime toutes les maisons du groupe
                    //non
                    //ne rien faire
                }else {
                    prop_nb_maison_min.addMaison(); //ajoute la maison a la propriété du groupe qui en a le moins

                }
                    prop_nb_maison_min.setPrixLoyer(tab_prixLoyer[nbMaison]);
            }
        }
    }
    /**
     * @return the groupe
     */
    public Groupe getGroupe() {
        return groupe;
    }
    
    @Override
    public boolean acheterPropriete(Joueur j){
        if(j.getCash() >= this.getPrixAchat()){
            this.setProprietaire(j);
            j.diminuerCash(this.getPrixAchat());
            j.addProprieteAConstruire(this);
            return true;
        }
        else{
            return false;
        }

    }
    
    @Override
    public int calculLoyer(int sommeLances) { // a changer prendre en compte les maisons
        int l = super.getPrixLoyer();
        
        Groupe g = this.getGroupe();
        Joueur j = super.getProprietaire();
        int nb = 0; //représente le nombre de propriétés du groupe (en fonction de la couleur) que posséde le propriétaire

        for (ProprieteAConstruire i : j.getPropietes_a_construire()){
            if (i.getGroupe().getCouleur().equals(this.getGroupe().getCouleur())){
                nb++;
            }
        }

        if (nb == this.getGroupe().getNbProprietes()) {
            return (l * 2);
        }
        else{
            return (l);
        }
    }

    /**
     * @return the nbMaison
     */
    public int getNbMaison() {
        return nbMaison;
    }

    /**
     * @param nbMaison the nbMaison to set
     */
    public void setNbMaison(int nbMaison) {
        this.nbMaison = nbMaison;
    }

    /**
     * @return the nbHotel
     */
    public int getNbHotel() {
        return nbHotel;
    }

    /**
     * @param nbHotel the nbHotel to set
     */
    public void addHotel() {
        this.nbHotel = 1;
    }
    
    public void removeMaisons(){
        //prix loyer
        //retirer propriétés au joueur
    } 
    public void addMaison(){
        this.nbMaison = nbMaison + 1;
    }       
}