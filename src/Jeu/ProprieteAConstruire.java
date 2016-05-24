package Jeu;

public class ProprieteAConstruire extends Propriete{
    
    private Groupe groupe;
    
    public ProprieteAConstruire (int num, String nom, Joueur proprietaire, int prixAchat, int prixLoyer, Groupe groupe){
        
            super(num, nom, proprietaire, prixAchat, prixLoyer);
            this.groupe = groupe;
            
        }

    /**
     * @return the groupe
     */
    public Groupe getGroupe() {
        return groupe;
    }
}