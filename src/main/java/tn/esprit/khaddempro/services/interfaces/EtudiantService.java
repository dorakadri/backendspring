package tn.esprit.khaddempro.services.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import tn.esprit.khaddempro.DAO.entities.Contrat;
import tn.esprit.khaddempro.DAO.entities.Etudiant;

public interface EtudiantService {
	List<Etudiant> retrieveAllEtudiants();

	Etudiant addEtudiant (Etudiant e);

	Etudiant updateEtudiant (Etudiant e);

	Etudiant retrieveEtudiant(Integer idEtudiant);

	void removeEtudiant(Integer idEtudiant);
	
	int searchEtudiantBynomEtprenom(String nom ,String prenom );

    Etudiant getEtudiantByNomE(String name);
    
    List<Etudiant> getAllEtudiantsBeginByNomE(String prefixe);
    void assignEtudiantToDepartement (Integer etudiantId, Integer departementId) ;

	Contrat affectContratToEtudiant (Contrat ce,String  nomE ,String prenomE);
 
	Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat,Integer idEquipe);
	Etudiant addAndAssignEtudiantToEquipe(Etudiant e,Integer idEquipe);

	void assignEtudiantToEquipe(Integer idequipe, Integer idEtudiant) ;
	////////////////////mte3firas/////////////////////


	
	public List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);
}
