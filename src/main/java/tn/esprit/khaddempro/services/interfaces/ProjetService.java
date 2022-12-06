package tn.esprit.khaddempro.services.interfaces;

import java.util.List;

import tn.esprit.khaddempro.DAO.entities.Equipe;
import tn.esprit.khaddempro.DAO.entities.Projet;
import tn.esprit.khaddempro.modals.project;

public interface ProjetService {
	List<Projet> retrieveAllProjets();

	Integer addProjet (Projet p);

	Projet updateProjet (Projet p , Integer fileid);

	Projet retrieveProjet (Integer idProjet);
	project retrieveProjetuniversityandequipe (Integer idProjet);
	
	void DeleteProjet (Integer idProjet);
	
	public void assignEquipeToProjet (List<Integer> idequipe,  int idprojet) ;
	
	public void assignfiletoproject (Integer file,Integer idproj) ;
	
	
	public List<Integer> getassignEquipeToProjet ( Integer
			idprojet) ;
	
	public void deleteequipe ( Integer
			idprojet,Integer idequipe) ;

	




	
}
