package edu.gestionbancaire.dao;



public class CpteEpargnePrevDao implements ICpteEpargnePrevDao {

	@Override
	public long debitercpte(long solde, int mt) {
		// TODO Auto-generated method stub
		return solde-mt;
	}

	@Override
	public long creditercpte(long solde, int mt) {
		// TODO Auto-generated method stub
		return solde+mt+200;
	}


	

	

}
