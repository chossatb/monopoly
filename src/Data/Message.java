/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author touronl
 */


public class Message {
    
    public enum Types{
        ACHETER_OU_PAS,
        ACHAT_PROPRIETE,
        PASSER,
        CARTE_AMENDE,
        CARTE_DEPLACEMENT,
        CARTE_MAISON_HOTEL,
        CARTE_GAIN,
        CARTE_ALLEZ_PRISON,
        CARTE_LIBERE_PRISON,
        CARTE_RECULER
    };
    
    public Types type;
    
    public String quest_achat;
    public String achat;
    public String passer;
    public String deplacement;
    
    
}
