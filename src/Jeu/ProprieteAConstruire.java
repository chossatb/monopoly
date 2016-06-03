package Jeu;

import java.util.Scanner;

public class ProprieteAConstruire extends Propriete{
    
    private Groupe groupe;
    
    public ProprieteAConstruire (int num, String nom, Joueur proprietaire, int prixAchat, int prixLoyer, Groupe groupe){
        
            super(num, nom, proprietaire, prixAchat, prixLoyer);
            this.groupe = groupe;
            
        }

            @Override
	public void action(Joueur aJ, int sommeLances) {
               Scanner sc = new Scanner(System.in);
               Joueur jProprio = this.getProprietaire();
               if (jProprio == null){
                   System.out.println("Argent total avant = " + aJ.getCash());
                   System.out.println("Voulez vous acheter la propri ? (y/n)" + " (Prix = " + this.getPrixAchat());
                   String saisie=sc.nextLine();
                   if (saisie.equals("y")){ 
                       this.acheterPropriete(aJ); 
                       System.out.println("Argent total apres = " + aJ.getCash());
                   }
               }
               super.action(aJ, sommeLances);

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
    public int calculLoyer(int sommeLances) {
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
          
}