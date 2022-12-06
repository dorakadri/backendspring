package tn.esprit.khaddempro.services.interfaces;

import java.util.Date;
import java.util.List;
import java.util.Map;

import tn.esprit.khaddempro.DAO.entities.Contrat;

public interface ContratService {
	List<Contrat> retrieveAllContrats();

	Contrat updateContrat (Contrat ce);

	Contrat addContrat (Contrat ce);

	Contrat retrieveContrat (Integer idContrat);

	void removeContrat(Integer idContrat);
	
	Contrat affectContratToEtudiant (Contrat ce, String nomE,String prenomE);
	
	public List<List<String>> getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
	
	public Integer nbContratsValides(Date startDate, Date endDate);
	
	public void retrieveAndUpdateStatusContrat();
}
