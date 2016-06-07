package Jeu;

import Data.Message;
import java.util.ArrayList;

public class AutreCarreau extends Carreau{
    
    public AutreCarreau(int num, String nom){
        super(num, nom);
    }
    
    @Override
    public Message action(Joueur aJ, int sommeLances, String choix){
        Message mess = new Message();
        
        return null;
    }
    
    public void allezEnPrison(Joueur j){
        
        if (j.getPosCourante().getNumero() == 31){
            //emmener le joueur j à la case 11 (prison) sans passer par la case départ
        }
    }
    
    public void tirerUneCarte(Joueur j, String dataFilename){
        ArrayList<String[]> data = readDataFile(dataFilename, ",");//erreur read datafile
        for(int i=0; i<data.size(); ++i){
                if (j.getPosCourante().getNomCarreau() == "Chance" || j.getPosCourante().getNomCarreau() == "Caisse de communauté"){
                    
                }
        }
    }
    
    
}