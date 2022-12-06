package tn.esprit.khaddempro.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.khaddempro.DAO.entities.Departement;
import tn.esprit.khaddempro.DAO.entities.Etudiant;
import tn.esprit.khaddempro.DAO.repository.DepartmentRepository;
import tn.esprit.khaddempro.services.interfaces.DepartmentService;

@Service
public class DepartmentServiceImplementation implements DepartmentService{
	@Autowired 
	DepartmentRepository deprep; 

	@Override
	public List<Departement> retrieveAllDepartements() {
		return deprep.findAll();
	}

	@Override
	public Departement addDepartement(Departement d) {
		 deprep.save(d);
		return d;
	}

	@Override
	public Departement updateDepartement(Departement d) {
		deprep.findById(d.getIdDepart()).get();
		deprep.save(d);
		return d;
	}

	@Override
	public Departement retrieveDepartement(Integer idDepart) {
		return deprep.findById(idDepart).get();
	}

	@Override
	public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
		return deprep.getEtudiantsByDepartement(idDepartement);
	}

	@Override
	public void DeleteDepartment(Integer id) {
		deprep.deleteById(id);
		
	}
	
	
	@Override
	public int GetNbrEnseignantInEveryDepartment(Integer id) {
		return deprep.GetNbrEnseignInEveryDepartment(id);
	}
}
