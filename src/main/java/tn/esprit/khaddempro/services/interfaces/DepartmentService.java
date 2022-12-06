package tn.esprit.khaddempro.services.interfaces;

import java.util.List;

import tn.esprit.khaddempro.DAO.entities.Departement;
import tn.esprit.khaddempro.DAO.entities.Etudiant;

public interface DepartmentService {
	List<Departement> retrieveAllDepartements();

	Departement addDepartement (Departement d);

	Departement updateDepartement (Departement d);

	Departement retrieveDepartement (Integer idDepart);
	
	List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);

	void DeleteDepartment(Integer idDepart);
	
	int GetNbrEnseignantInEveryDepartment(Integer id);
}
