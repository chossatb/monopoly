package Jeu;

import Data.Message;



public abstract class Carreau {
	private int numero;
	private String nomCarreau;

        
        public Carreau(int num, String nom){
            this.setNomCarreau(nom);
            this.setNumero(num);   
        }
        
        
	public int getNumero() {
		return this.numero;
	}

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the nomCarreau
     */
    public String getNomCarreau() {
        return nomCarreau;
    }

    /**
     * @param nomCarreau the nomCarreau to set
     */
    public void setNomCarreau(String nomCarreau) {
        this.nomCarreau = nomCarreau;
    }
    public abstract Message action(Joueur aJ, int sommeLances, String choix);
}