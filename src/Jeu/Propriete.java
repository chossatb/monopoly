/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

/**
 *
 * @author milleree
 */
public abstract class Propriete extends Carreau {
    private Joueur proprietaire;
    private int prixAchat;
    private int prixLoyer;
    
    public Propriete (int num, String nom, Joueur proprietaire, int prixAchat, int prixLoyer){
        super(num, nom);
        this.setProprietaire(proprietaire);
        this.prixAchat = prixAchat;
        this.prixLoyer = prixLoyer;
    }

    /**
     * @return the proprietaire
     */
    public Joueur getProprietaire() {
        return proprietaire;
    }
    
    public int getPrixAchat(){
        return this.prixAchat;
    }
    
    public int getPrixLoyer(){
        return this.prixLoyer;
    }
    

    /**
     * @param proprietaire the proprietaire to set
     */
    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }
    
    
    public int calculLoyer(){ //a compléter
        return 0;
    }
    
    public abstract boolean acheterPropriete(Joueur j);
//        if(j.getCash() >= this.getPrixAchat()){
//            this.setProprietaire(j);
//            j.diminuerCash(this.getPrixAchat());
//            j.addPropriete(this);
//            return true;
//        }
//        else{
//            return false;

        //faire dans priprio, gare et compagnie
        
    }
    
}
