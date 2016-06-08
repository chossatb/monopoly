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
        private HashMap<Integer, CartesChance> carteschance;
        private HashMap<Integer, CartesCaisseDeCommunaute> cartescaisse;
    
        public Monopoly(){
            this.carreaux = new HashMap<Integer, Carreau>();
            this.joueurs =  new HashMap<Integer, Joueur>();
            this.carteschance = new HashMap<Integer, CartesChance>();
            this.cartescaisse = new HashMap<Integer, CartesCaisseDeCommunaute>();
        }
    
	public void CreerPlateau(String dataFilename, String chanceFilename, String caisseFilename){ //type de retour à vérifier
		buildGamePlateau(dataFilename,chanceFilename,caisseFilename);
	}
	
	private void buildGamePlateau(String dataFilename, String chanceFilename, String caisseFilename)
	{
		try{
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
			ArrayList<String[]> chance = readChanceFile(chanceFilename, ",");
			ArrayList<String[]> caisse = readCaisseFile(caisseFilename, ",");
			
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
                                int tab_prixLoyer[];
                                
                                tab_prixLoyer = new int[6]; //Pour calculer le loyer des proprietes
                                
                                int prixLoyer = 0; //Pour calculer le loyer des compagnies et des gares
                                
                                

                                
                                
                                if (caseType.equals("G") || caseType.equals("C") ) {
                                    prixAchat = Integer.parseInt(data.get(i)[3]);
                                }
                                
                                
                               
                                
         
				if(caseType.compareTo("P") == 0){
                                    prixAchat = Integer.parseInt(data.get(i)[4]);
                                    tab_prixLoyer[0] = Integer.parseInt(data.get(i)[5]);
                                    tab_prixLoyer[1] = Integer.parseInt(data.get(i)[6]);
                                    tab_prixLoyer[2] = Integer.parseInt(data.get(i)[7]);
                                    tab_prixLoyer[3] = Integer.parseInt(data.get(i)[8]);
                                    tab_prixLoyer[4] = Integer.parseInt(data.get(i)[9]);
                                    tab_prixLoyer[5] = Integer.parseInt(data.get(i)[10]);
                                    carreaux.put(numero, new ProprieteAConstruire(numero, nom, null, prixAchat, tab_prixLoyer, groupes.get(CouleurPropriete.valueOf(data.get(i)[3]))));
                                }

				else if(caseType.compareTo("G") == 0){
					//System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        prixLoyer = 0;
                                        carreaux.put(numero, new Gare(numero, nom, null, prixAchat, prixLoyer));
				}
				else if(caseType.compareTo("C") == 0){
					//System.out.println("Compagnie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        prixLoyer = 0;
                                        carreaux.put(numero, new Compagnie(numero, nom, null, prixAchat, prixLoyer));
				}
				else if(caseType.compareTo("AU") == 0){
                                    if(nom.compareTo("Départ") == 0){
                                        carreaux.put(numero, new Depart(numero,nom));
                                    }
                                    else if(nom.compareTo("Caisse de Communauté") == 0){
                                        carreaux.put(numero, new CaisseDeCommunaute(numero,nom));
                                    }
                                    else if(nom.compareTo("Impôt sur le revenu") == 0){
                                        carreaux.put(numero, new Impots(numero,nom));
                                    }
                                    else if(nom.compareTo("Chance") == 0){
                                        carreaux.put(numero, new Chance(numero,nom));
                                    }
                                    else if(nom.compareTo("Simple Visite / En Prison") == 0){
                                        carreaux.put(numero, new Prison(numero,nom));
                                    }
                                    else if(nom.compareTo("Parc Gratuit") == 0){
                                        carreaux.put(numero, new ParcGratuit(numero,nom));
                                    }
                                    else if(nom.compareTo("Allez en prison") == 0){
                                        carreaux.put(numero, new AllezEnPrison(numero,nom));
                                    }
                                    else if(nom.compareTo("Taxe de Luxe") == 0){
                                        carreaux.put(numero, new TaxeDeLuxe(numero,nom));
                                    }
                                    
					//System.out.println("Case Autre :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
//                                        carreaux.put(numero, new AutreCarreau(numero, nom));
				}
				else
					System.err.println("[buildGamePleateau()] : Invalid Data type");
			}
                        for(int i = 0; i<chance.size(); ++i){
                            
                            String caseType = chance.get(i)[0];
                            String nom = chance.get(i)[2];
                            int numero = Integer.parseInt(chance.get(i)[1]);
                            if (caseType.compareTo("AM") == 0) {
                                int prixAmende = Integer.parseInt(chance.get(i)[3]);
                                carteschance.put(numero, new CartesChance(nom, numero, caseType, prixAmende));
                            }
                            else if (caseType.compareTo("GA") == 0) {
                                int prixGain = Integer.parseInt(chance.get(i)[3]);
                                carteschance.put(numero, new CartesChance(nom, numero, caseType, prixGain));
                            }
                            else if(caseType.compareTo("MH") == 0){
                                int prixParMaison = Integer.parseInt(chance.get(i)[4]);
                                carteschance.put(numero, new CartesChance(nom, numero, caseType, prixParMaison, prixParMaison));
                            }
                            else if(caseType.compareTo("DE") == 0 || caseType.compareTo("LI") == 0 || caseType.compareTo("PR") == 0 ||caseType.compareTo("RE") == 0){
                                carteschance.put(numero, new CartesChance(nom, numero, caseType));
                            }
                            else{
                                System.err.println("[buildGamePleateau()] : Invalid Data type");
                            }
                        }
                        for(int i = 0; i<caisse.size(); ++i){
                            
                            String caseType = caisse.get(i)[0];
                            String nom = caisse.get(i)[2];
                            int numero = Integer.parseInt(caisse.get(i)[1]);
                            if (caseType.compareTo("AM") == 0) {
                                int prixAmende = Integer.parseInt(caisse.get(i)[3]);
                                cartescaisse.put(numero, new CartesCaisseDeCommunaute(nom, numero, caseType, prixAmende));
                            }
                            else if (caseType.compareTo("GA") == 0 || caseType.compareTo("HB") == 0) {
                                int prixGain = Integer.parseInt(caisse.get(i)[3]);
                                cartescaisse.put(numero, new CartesCaisseDeCommunaute(nom, numero, caseType, prixGain));
                            }
                            else if(caseType.compareTo("DE") == 0 || caseType.compareTo("LI") == 0 || caseType.compareTo("PR") == 0){
                                cartescaisse.put(numero, new CartesCaisseDeCommunaute(nom, numero, caseType));
                            }
                            else{
                                System.err.println("[buildGamePleateau()] : Invalid Data type");
                            }
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
        
        private ArrayList<String[]> readChanceFile(String filename, String token) throws FileNotFoundException, IOException
	{
		ArrayList<String[]> chance = new ArrayList<String[]>();
		
		BufferedReader reader  = new BufferedReader(new FileReader(filename));
		String line = null;
		while((line = reader.readLine()) != null){
			chance.add(line.split(token));
		}
		reader.close();
		
		return chance;
	}
        private ArrayList<String[]> readCaisseFile(String filename, String token) throws FileNotFoundException, IOException
	{
		ArrayList<String[]> caisse = new ArrayList<String[]>();
		
		BufferedReader reader  = new BufferedReader(new FileReader(filename));
		String line = null;
		while((line = reader.readLine()) != null){
			caisse.add(line.split(token));
		}
		reader.close();
		
		return caisse;
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

