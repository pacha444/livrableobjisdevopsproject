package edu.gestionbancaire.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.gestionbancaire.dao.CpteEpargnePrevDao;
import edu.gestionbancaire.dao.ICpteEpargnePrevDao;
import edu.gestionbancaire.domaine.CompteCourantSal;
import edu.gestionbancaire.domaine.CpteEpargnePrev;
import edu.gestionbancaire.domaine.Groupement;
import edu.gestionbancaire.domaine.Persphysique;

class ServiceBancaireTestAvecMock {
	static Persphysique pers = null;
	static Groupement groupement = null;
	static	CpteEpargnePrev cpteep = null;
	static	CompteCourantSal cpts = null;
	ICpteEpargnePrevDao cep=null;
	CpteEpargnePrevDao cepdao;
	@BeforeAll
	public static  void initialisergen()
	{
		groupement = new Groupement(1, "+221781277881", "pamoussacisse@gmail.com", "Kundal Group", "238761",
				"12JZER", "papa moussa cisse", "1870198702386");
			cpteep = new CpteEpargnePrev("2", "Dakar Bourguiba", 40000, 5000, groupement, pers);
			pers = new Persphysique(2, "772953450", "diopsy@gmail.com", "4567", "Diop", "Sy", "1870198702386", 2, "marie");
			cpts = new CompteCourantSal("3", "Dakar Plateau", 200000, 180000, 2000, pers);
	}

	@BeforeEach
	void setUp() throws Exception {
	
		
			cep=mock(ICpteEpargnePrevDao.class);
			when(cep.debitercpte(cpteep.getSolde(), 30000)).thenReturn((long) 10000);
			when(cep.creditercpte(cpteep.getSolde(), 30000)).thenReturn((long) 70200);
			cepdao=new CpteEpargnePrevDao();
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testmethodedebiter() {

		assertEquals((long)10000, cepdao.debitercpte(cpteep.getSolde(), 30000));
	}
	@Test
	void testmethodecrediter() {

		assertEquals((long)10000, cepdao.debitercpte(cpteep.getSolde(), 30000));
		assertEquals((long)70200,  cepdao.creditercpte(cpteep.getSolde(), 30000), "Bon resultat");
	}

}
