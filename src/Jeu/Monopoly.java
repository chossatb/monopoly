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
                                int prixLoyer=0;
                                

                                
                                
                                if (caseType.equals("G") || caseType.equals("C") ) {
                                    prixAchat = Integer.parseInt(data.get(i)[3]);
                                }
                                
                                
                               
                                
         
				if(caseType.compareTo("P") == 0){
                                    prixAchat = Integer.parseInt(data.get(i)[4]);
                                    prixLoyer = Integer.parseInt(data.get(i)[5]);
                                    carreaux.put(numero, new ProprieteAConstruire(numero, nom, null, prixAchat, prixLoyer, groupes.get(CouleurPropriete.valueOf(data.get(i)[3]))));
                                }

				else if(caseType.compareTo("G") == 0){
					//System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.put(numero, new Gare(numero, nom, null, prixAchat, prixLoyer));
				}
				else if(caseType.compareTo("C") == 0){
					//System.out.println("Compagnie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.put(numero, new Compagnie(numero, nom, null, prixAchat, prixLoyer));
				}
				else if(caseType.compareTo("AU") == 0){
					//System.out.println("Case Autre :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.put(numero, new AutreCarreau(numero, nom));
				}
				else
					System.err.println("[buildGamePleateau()] : Invalid Data type");
			}
                        
//                        for (HashMap.Entry<Integer, Carreau> c : carreaux.entrySet()){
//                            System.out.println(c.getValue().getNumero() + " : " + c.getValue().getNomCarreau());
//                        }
			
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

    
        
        public void creerJoueur(Joueur j) {
            if ( getJoueurs().size() < 6 ) { // au moins plus de 2 joueurs
                getJoueurs().put(getJoueurs().size(), j);
            } else {
                System.out.println("Error : trop de joueurs");
            }       
        }
        
        public Carreau getCarreau(int num){
            
            return carreaux.get(num);
            
        }
        
        public void parcourJoueurs(){
            for (HashMap.Entry<Integer, Joueur> j : getJoueurs().entrySet()){
                System.out.println(j.getValue().getNom());
            } 
        }

    /**
     * @return the joueurs
     */
    public HashMap<Integer, Joueur> getJoueurs() {
        return joueurs;
    }
    
    public HashMap<Integer, Carreau> getCarreaux() {
        return carreaux;
    }
        
        
        
        
        
}

