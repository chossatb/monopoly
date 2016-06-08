/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

/**
 *
 * @author guinatha
 */
public class CartesChance {
    private String nom;
    private int num;
    private String type;
    private int prix;
    private int prixParMaison;
    private int prixParHotel;
    
    public CartesChance(String nom, int num){
        setNom(nom);
        setNum(num);
        setType("");
        setPrix(0);
        setPrixParMaison(0);
        setPrixParHotel(0);
        
    }
    
    public CartesChance(String nom, int num, String type){
        setNom(nom);
        setNum(num);
        setType(type);
        setPrix(0);
        setPrixParMaison(0);
        setPrixParHotel(0);
    }
    
    public CartesChance(String nom, int num, String type, int prix){
        setNom(nom);
        setNum(num);
        setType(type);
        setPrix(prix);
        setPrixParMaison(0);
        setPrixParHotel(0);
    }
    
    public CartesChance(String nom, int num, String type, int prixParMaison, int prixParHotel){
        setNom(nom);
        setNum(num);
        setType(type);
        setPrix(0);
        setPrixParMaison(prixParMaison);
        setPrixParHotel(prixParHotel);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getPrixParMaison() {
        return prixParMaison;
    }

    public void setPrixParMaison(int prixParMaison) {
        this.prixParMaison = prixParMaison;
    }

    public int getPrixParHotel() {
        return prixParHotel;
    }

    public void setPrixParHotel(int prixParHotel) {
        this.prixParHotel = prixParHotel;
    }
    
}
