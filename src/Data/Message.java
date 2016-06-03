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
        PASSER  
    };
    
    public Types type;
    
    public String quest_achat;
    public String achat;
    public String passer;
    
    
}
