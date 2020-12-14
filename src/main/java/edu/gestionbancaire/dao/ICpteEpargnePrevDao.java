package edu.gestionbancaire.dao;

public interface ICpteEpargnePrevDao {
	
	public long debitercpte(long solde,int mt);
	public long creditercpte(long solde,int mt);
	

}
