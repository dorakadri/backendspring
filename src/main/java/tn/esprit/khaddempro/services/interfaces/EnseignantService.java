package tn.esprit.khaddempro.services.interfaces;

import java.util.List;

import tn.esprit.khaddempro.DAO.entities.Enseignant;

public interface EnseignantService {
	List<Enseignant> retrieveAllEnseignants();

	Enseignant addEnseignant (Enseignant e);

	Enseignant updateEnseignant (Enseignant e);

	Enseignant retrieveEnseignant(Integer idenseignant);

	void removeEnseignant(Integer idenseignant);
	
	int searchEnseignantBynomEtprenom(String nom ,String prenom );
    
    List<Enseignant> getAllEnseignantBeginByNom(String prefixe);
    
    void assignEnseignantToDepartement (Integer idenseignant, Integer departementId) ; 
    
    int searchEnseignantByIdDepart(Integer id);
}
