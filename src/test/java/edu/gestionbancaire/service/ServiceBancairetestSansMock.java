package edu.gestionbancaire.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.gestionbancaire.domaine.CompteCourantSal;
import edu.gestionbancaire.domaine.CpteEpargnePrev;
import edu.gestionbancaire.domaine.Groupement;
import edu.gestionbancaire.domaine.Persphysique;
import edu.gestionbancaire.exceptions.AgioException;
import edu.gestionbancaire.exceptions.CinException;
import edu.gestionbancaire.exceptions.FraisOuvException;
import edu.gestionbancaire.exceptions.SitMatException;

class ServiceBancairetestSansMock {
	
	
	ServiceBancaireSansMock servicebancaire;
	private static Groupement groupement=null;
	private static Persphysique pers=null;
	private static CpteEpargnePrev cpteep=null;
	private static CompteCourantSal cpts=null;
	
	@BeforeAll
	public  static void initialisergen()
	{
		groupement = new Groupement(1, "+221781277881", "pamoussacisse@gmail.com", "Kundal Group", "238761",
				"12JZER", "papa moussa cisse", "1870198702386");
			cpteep = new CpteEpargnePrev("2", "Dakar Bourguiba", 40000, 5000, groupement, pers);
			pers = new Persphysique(2, "772953450", "diopsy@gmail.com", "4567", "Diop", "Sy", "1870198702386", 2, "marie");
			cpts = new CompteCourantSal("3", "Dakar Plateau", 200000, 180000, 2000, pers);
	}

	
	@BeforeEach
	public void initialiser()
	{
	 servicebancaire=new ServiceBancaireSansMock ();
	}

	@Test
	void testifmembreestungrp() {
		
	
		assertEquals("groupement",  servicebancaire.operationbank("A"));
	}
	
	@Test
	void testifmembreestunepphys() {
		
	
		assertEquals("personne physique",  servicebancaire.operationbank("B"));
	}
	@Test
	void verifierlongueurcinmandataire() throws CinException {
		
	
		assertEquals("boncin", servicebancaire.testlongcin("1870198702386"));
	}
	@Test
	void verifierfraisouv() throws  FraisOuvException {
		
		
		assertEquals("bonfouv", servicebancaire.testfraisouv(5000));
	}
	
	@Test
	void verifieragios() throws   AgioException {
		
		
		assertEquals("bonagios", servicebancaire.testagios(2000));
	}
	
	@Test
	void verifiersitmat() throws SitMatException  {
		
		
		assertEquals("bonsitmat", servicebancaire.testsitmat("celibataire"));
	}
	
	
	@Test
	void verifiercreatecpteepargne() throws   CinException, FraisOuvException {
		
		assertTrue("non exact", cpteep.getFraisouverture()==(servicebancaire.createcpteep("1870198702386", 5000)).getFraisouverture());
		System.out.println(cpteep+" "+servicebancaire.createcpteep("1870198702386", 5000));
		assertTrue("non exact", cpteep.getIdcompte()==(servicebancaire.createcpteep("1870198702386", 5000)).getIdcompte());
	
	}	
	@Test
	void verifiercreatecptesal() throws   CinException, FraisOuvException, AgioException, SitMatException {
		
		assertTrue("non exact", cpts.getSal()==(servicebancaire.createcptesal("1870198702386", "marie", 2000)).getSal());
		
		assertTrue("non exact", cpts.getIdcompte()==(servicebancaire.createcptesal("1870198702386", "marie", 2000)).getIdcompte());
	
	}	
	
	
	
	@Test
	
  void test()  {
		int a=1;
		int b=1;
		
		assertTrue("non exact", a==b);
	}

}
