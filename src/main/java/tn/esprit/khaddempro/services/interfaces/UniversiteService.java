package tn.esprit.khaddempro.services.interfaces;

import java.util.List;

import tn.esprit.khaddempro.DAO.entities.Departement;
import tn.esprit.khaddempro.DAO.entities.Universite;

public interface UniversiteService {
	List<Universite> retrieveAllUniversites();
	Universite addUniversite (Universite u);
	Universite updateUniversite (Universite u);
	Universite retrieveUniversite (Integer idUniversite);
	Universite getUniversiteById(Integer idUniversite);
	
	
	public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
	void removeUniver(Integer idUniversite);
	List<Departement> getDepartementAffected();
	void assignUniversiteToDepartement(int idUniversite, List<Integer> idDepartement);
	//public void assignUniversiteToDepartement(Integer idUniversite, Integer
		//	idDepartement);

	
}