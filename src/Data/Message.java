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
        CARTE_MAISON_HOTEL,
        CARTE_GAIN,
        CARTE_ALLEZ_PRISON,
        CARTE_LIBERE_PRISON,
        CARTE_RECULER,
        CARTE_DEPART,
        CARTE_GARE_DE_LYON,
        CARTE_AVENUE_HENRI_MARTIN,
        CARTE_RUE_DE_LA_PAIX,
        CARTE_BOULEVARD_DE_LA_VILETTE,
        CARTE_BELLEVILLE,
    };
    
    public Types type;
    
    public String quest_achat;
    public String achat;
    public String passer;
    public String deplacement;
    
    
}
