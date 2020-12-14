package edu.gestionbancaire.service;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import edu.gestionbancaire.domaine.CompteCourantSal;
import edu.gestionbancaire.domaine.CpteEpargnePrev;
import edu.gestionbancaire.domaine.Groupement;
import edu.gestionbancaire.domaine.Persphysique;
import edu.gestionbancaire.exceptions.AgioException;
import edu.gestionbancaire.exceptions.CinException;
import edu.gestionbancaire.exceptions.FraisOuvException;
import edu.gestionbancaire.exceptions.SitMatException;

@RunWith(MockitoJUnitRunner.class)
public class ServiceBancaireTest {
	@Mock
	private ServiceBancaireBeta service;

    CompteCourantSal cpts;

	Persphysique pers;
	
	CpteEpargnePrev cpte;

	 Groupement groupement;
	
	@BeforeEach
	public void Init() throws CinException, FraisOuvException, SitMatException, AgioException
    {
		
	
		service=new ServiceBancaireBeta();
		Persphysique pers = new Persphysique(2, "772953450", "diopsy@gmail.com", "4567", "Diop", "Sy", "1870198702386",
				3, "marie");
		 cpts = new CompteCourantSal("3", "Dakar Plateau", 200000, 180000, 2000, pers);
		 
		 groupement = new Groupement(1, "+221781277881", "pamoussacisse@gmail.com", "KundalGroup", "238761",
					"12JZER", "papa moussa cisse", "1870198702386");
				cpte = new CpteEpargnePrev("2", "Dakar Bourguiba", 40000, 5000, groupement, pers);
    }

	
	@Test
	public void test() throws CinException, FraisOuvException, AgioException, SitMatException {

		assertEquals(cpte, service.operationgrp("1870198702386", "A", 5000));
		
		
		Mockito.verify(service).operationgrp("1870198702386", "A", 5000);

	}

	@Test
	@DisplayName("Test for create customer")
	public void testcli() throws CinException, FraisOuvException, SitMatException, AgioException {

	  System.out.println("cpte="+cpts);
		assertEquals(cpts, service.operationcli("1870198702386", "marie", 3, 2000));
		
	}
	
	

}
