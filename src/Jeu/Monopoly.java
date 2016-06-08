package Jeu;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Monopoly {
    
    /* P,2,Bd de Belleville,mauve,60,2,10,30,90,160,250,50,50
    60=pris achat 
    2=prix loyer terrain nu
    10=prix location 1 maison
    30=prix location 2 maison
    90=prix location 3 maison
    160=prix location 4 maison
    250=prix location hotel
    50=prix achat maison
    50=prix achat hotel
    */
    
        private HashMap<Integer, Carreau> carreaux;
        private HashMap<Integer, Joueur> joueurs;
    
        public Monopoly(){
            this.carreaux = new HashMap<Integer, Carreau>();
            this.joueurs =  new HashMap<Integer, Joueur>();
        }
    
	public void CreerPlateau(String dataFilename){ //type de retour à vérifier
		buildGamePlateau(dataFilename);
	}
	
	private void buildGamePlateau(String dataFilename)
	{
		try{
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
			
			//TODO: create cases instead of displaying
                        
                        HashMap<CouleurPropriete, Groupe> groupes = new HashMap<CouleurPropriete, Groupe>();

                        for (CouleurPropriete couleur : CouleurPropriete.values()){
               
                            groupes.put(couleur,new Groupe(couleur));
                        }
                        
                        
			for(int i=0; i<data.size(); ++i){
                            
				String caseType = data.get(i)[0];
                                
                                String nom = data.get(i)[2];

                                int numero = Integer.parseInt(data.get(i)[1]);
                                int prixAchat=0;
                                int prixLoyer_nu=0;
                                int prixLoyer_1_maison=0;
                                int prixLoyer_2_maisons=0;
                                int prixLoyer_3_maisons=0;
                                int prixLoyer_4_maisons=0;
                                int prixLoyer_1_hotel=0;
                                

                                
                                
                                if (caseType.equals("G") || caseType.equals("C") ) {
                                    prixAchat = Integer.parseInt(data.get(i)[3]);
                                }
                                
                                
                               
                                
         
				if(caseType.compareTo("P") == 0){
                                    prixAchat = Integer.parseInt(data.get(i)[4]);
                                    prixLoyer_nu = Integer.parseInt(data.get(i)[5]);
                                    prixLoyer_1_maison = Integer.parseInt(data.get(i)[6]);
                                    prixLoyer_2_maisons = Integer.parseInt(data.get(i)[7]);
                                    prixLoyer_3_maisons = Integer.parseInt(data.get(i)[8]);
                                    prixLoyer_4_maisons = Integer.parseInt(data.get(i)[9]);
                                    prixLoyer_1_hotel = Integer.parseInt(data.get(i)[10]);
                                    carreaux.put(numero, new ProprieteAConstruire(numero, nom, null, prixAchat, prixLoyer_nu, groupes.get(CouleurPropriete.valueOf(data.get(i)[3]))));
                                }

				else if(caseType.compareTo("G") == 0){
					//System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.put(numero, new Gare(numero, nom, null, prixAchat, prixLoyer_nu));
				}
				else if(caseType.compareTo("C") == 0){
					//System.out.println("Compagnie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.put(numero, new Compagnie(numero, nom, null, prixAchat, prixLoyer_nu));
				}
				else if(caseType.compareTo("AU") == 0){
                                    // if(nom.compareTo("Caisse de Communauté") == 0){
                                        //carreaux.put(numero, new CaisseDeCommunaute(numero,nom);
                                    //}
                                    //else if(nom.compareTo("Départ") == 0){
                                        //carreaux.put(numero, new Depart(numero,nom);
                                    //}else if(nom.compareTo("Impôt sur le revenu") == 0){
                                        //carreaux.put(numero, new Impots(numero,nom);
                                    //}
					//System.out.println("Case Autre :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.put(numero, new AutreCarreau(numero, nom));
				}
				else
					System.err.println("[buildGamePleateau()] : Invalid Data type");
			}
                        
			
		} 
		catch(FileNotFoundException e){
			System.err.println("[buildGamePlateau()] : File is not found!");
		}
		catch(IOException e){
			System.err.println("[buildGamePlateau()] : Error while reading file!");
		}
	}
	
	private ArrayList<String[]> readDataFile(String filename, String token) throws FileNotFoundException, IOException
	{
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		BufferedReader reader  = new BufferedReader(new FileReader(filename));
		String line = null;
		while((line = reader.readLine()) != null){
			data.add(line.split(token));
		}
		reader.close();
		
		return data;
	}

        
        public Carreau getCarreau(int num){
            
            return carreaux.get(num);
            
        }
        
   
        

    public HashMap<Integer, Joueur> getJoueurs() {
        return joueurs;
    }
    
    public HashMap<Integer, Carreau> getCarreaux() {
        return carreaux;
    }

    /**
     * @param joueurs the joueurs to set
     */
    public void creerJoueurs(HashMap<Integer, Joueur> joueurs) {
        this.joueurs = joueurs;
    }
        
        
        
        
        
}

