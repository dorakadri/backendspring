package tn.esprit.khaddempro.services.interfaces;

import java.util.List;

import tn.esprit.khaddempro.DAO.entities.Equipe;
import tn.esprit.khaddempro.DAO.entities.Etudiant;

public interface EquipeService {
	List<Equipe> retrieveAllEquipes();

	Equipe addEquipe(Equipe e); // ajouter l’équipe avec son détail

	Equipe updateEquipe (Equipe e);

	Equipe retrieveEquipe (Integer idEquipe);
	
	void DeleteEquipe (Integer idEquipe);
	
	Equipe affecterDetailsToEquipe(int IdEquipe, int IdDetailsEquipe);
	
    Etudiant assignEquipeToEtudiant(int idEquipe,int idEtudiant); 
//	void faireEvoluerEquipes();
	
}
