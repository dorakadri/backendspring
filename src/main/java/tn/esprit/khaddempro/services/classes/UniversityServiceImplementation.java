package tn.esprit.khaddempro.services.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.khaddempro.DAO.entities.Departement;
import tn.esprit.khaddempro.DAO.entities.Universite;
import tn.esprit.khaddempro.DAO.repository.DepartmentRepository;
import tn.esprit.khaddempro.DAO.repository.UniversityRepository;
import tn.esprit.khaddempro.services.interfaces.UniversiteService;

@Service
@Slf4j
public class UniversityServiceImplementation implements UniversiteService {
	@Autowired
	UniversityRepository univrep;
	@Autowired 
	DepartmentRepository deprep; 

	@Override
	public List<Universite> retrieveAllUniversites() {
		if(univrep.findAll()==null) {
		 log.error("error fetching universities " );
		}
		return univrep.findAll();
	}

	@Override
	public Universite addUniversite(Universite u) {
	u=univrep.save(u);
	return u;
	}

	@Override
	public Universite updateUniversite(Universite u) {
		   
		  log.info(""+u);
	     
	     return  univrep.save(u);
	}

	@Override
	public Universite retrieveUniversite(Integer idUniversite) {
		return univrep.findById(idUniversite).get();
	}
	@Override
	public Universite getUniversiteById(Integer idUniversite) {
		return univrep.findById(idUniversite).get();
	}



	@Override
	public void assignUniversiteToDepartement(int idUniversite, List<Integer> idDepartement) {
		
	 Universite u =univrep.findById(idUniversite).get(); 
	 List<Departement> departmentstoremove=   u.getDepart() ;
	 u.getDepart().removeAll(departmentstoremove);
	 List <Departement> departments = new ArrayList<>();
	 for (Integer i : idDepartement) {
		 Departement d=deprep.findById(i).get();
		 departments.add(d);
		
	}


	u.getDepart().addAll(departments);
	log.info("adding department to university...");
	univrep.save(u);
	log.info("added succesfuly...");

	}

	@Override
	public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
	 	return null ;
	 			//univrep.retrieveDepartementsByUniversite(idUniversite);
	}

	@Override
	public void removeUniver(Integer idUniversite) {
		univrep.deleteById(idUniversite);	
		    //etudrep.delete(etudrep.findById(id)); 
	}

	public List<Departement> getDepartementAffected() {
		List<Integer>  departmentid  = univrep.getDepartementAffected();
		
	return    deprep.findAllById(departmentid);
	}

	}
