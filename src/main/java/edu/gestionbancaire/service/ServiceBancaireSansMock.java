package edu.gestionbancaire.service;

import java.util.Scanner;

import edu.gestionbancaire.domaine.CompteCourantSal;
import edu.gestionbancaire.domaine.CpteEpargnePrev;
import edu.gestionbancaire.domaine.Groupement;
import edu.gestionbancaire.domaine.Persphysique;
import edu.gestionbancaire.exceptions.AgioException;
import edu.gestionbancaire.exceptions.CinException;
import edu.gestionbancaire.exceptions.FraisOuvException;
import edu.gestionbancaire.exceptions.SitMatException;

public class ServiceBancaireSansMock {
	
	String choixmembre;
	Persphysique pers = null;
	Groupement groupement = null;
	CpteEpargnePrev cpte = null;
	CompteCourantSal cpts = null;
	String cin = "";
	int fraisouv;
	int agios;
	Scanner saisiegenerale = new Scanner(System.in);

	public String operationbank(String choice) {
		String res = null;
		// TODO Auto-generated method stub
		System.out.println("Choisissez le type de membre (A pour groupement, B pour personne physique:");
		if (choice.equals("A")) {
			res="groupement";
		}
		if (choice.equals("B")) {
			res="personne physique";
		}
		
		return res;

	}

	public String testlongcin(String cin) throws CinException {
		String rese;
		if (cin.length() < 13 ) {
			throw new CinException("La longueur doit etre egale à 13");
		}
		else
		{
			rese="boncin";
		}
		return rese;
	}

	public String testfraisouv(int fraisouv) throws FraisOuvException {
		
	       String rfv;
		if (fraisouv < 5000) {

			throw new FraisOuvException("Les frais d'ouverture doivent etre supérieur ou égal à 5000 F CFA");
		}
		
		else {
			rfv="bonfouv";
		}
		return rfv;
	}

	public String testagios(int agios) throws AgioException {
	    String ragios;
	    if (agios <= 0 || agios > 2000) {


				throw new AgioException("Les agios ne doivent pas dépasser 2000 F CFA");
			}
			
			else {
				ragios="bonagios";
			}
			return ragios;
	}
	public String testsitmat(String sitmat) throws SitMatException {
		String smat;
		switch (sitmat)

		{

		case "celibataire":
			smat="bonsitmat";
			break;
		case "marie":
			smat="bonsitmat";
			break;
		case "divorce":
			smat="bonsitmat";
			break;
		// Les autres cas restants
		default:
			throw new SitMatException("Cette situation n'est pas prise en compte");
		}
		return smat;
	}
	public CpteEpargnePrev createcpteep(String cine,int fraisouve) throws CinException, FraisOuvException {
		testlongcin(cine);
		testfraisouv(fraisouve);
		groupement = new Groupement(1, "+221781277881", "pamoussacisse@gmail.com", "Kundal Group", "238761",
				"12JZER", "papa moussa cisse", cine);
			cpte = new CpteEpargnePrev("2", "Dakar Bourguiba", 40000, fraisouve, groupement, pers);
		
	
		return cpte;
	}
	
	public CompteCourantSal createcptesal(String cine,String sitmat,int agiose) throws CinException, AgioException, SitMatException {
		testlongcin(cine);
		testagios(agiose);
		testsitmat(sitmat);
		
		pers = new Persphysique(2, "772953450", "diopsy@gmail.com", "4567", "Diop", "Sy", cine, 2, sitmat);
		cpts = new CompteCourantSal("3", "Dakar Plateau", 200000, 180000, agiose, pers);
		
	
		return cpts;
	}
	
	

	



	
	

}
