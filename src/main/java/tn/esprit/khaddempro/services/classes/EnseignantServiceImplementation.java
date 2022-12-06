package tn.esprit.khaddempro.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.khaddempro.DAO.entities.Departement;
import tn.esprit.khaddempro.DAO.entities.Enseignant;
import tn.esprit.khaddempro.DAO.repository.DepartmentRepository;
import tn.esprit.khaddempro.DAO.repository.EnseignantRepository;
import tn.esprit.khaddempro.services.interfaces.EnseignantService;

@Service
@Slf4j
public class EnseignantServiceImplementation implements EnseignantService{
	 @Autowired
	 EnseignantRepository enseigrep ;
	  @Autowired
	  DepartmentRepository deprep ;
	
	@Override
	public List<Enseignant> retrieveAllEnseignants() {
		 return enseigrep.findAll();
	}

	@Override
	public Enseignant addEnseignant(Enseignant e) {
		try {
			log.info(" adding enseignant ... ");
			enseigrep.save(e);
		    log.info("enseignant added successfuly");
			}catch(Exception exp) {
	         log.info("test1"+exp.getStackTrace());			
			}
			
			return e;
	}

	@Override
	public Enseignant updateEnseignant(Enseignant e) {
		log.info(""+e.getIdenseignant()+"Data before saving");
	      log.info("saving new values ...");
	    
	    	  log.info("save"+e);
	    	  
	    	  return enseigrep.save(e);
	}

	@Override
	public Enseignant retrieveEnseignant(Integer idenseignant) {
		return enseigrep.findById(idenseignant).get();
	}

	@Override
	public void removeEnseignant(Integer idenseignant) {
		enseigrep.deleteById(idenseignant);	
		
	}

	@Override
	public List<Enseignant> getAllEnseignantBeginByNom(String name) {
		log.info(""+name);
		return enseigrep.getAllEnseignantsBeginByNom(name);
	}

	@Override
	public void assignEnseignantToDepartement(Integer idenseignant, Integer departementId) {
		Enseignant e = enseigrep.findById(idenseignant).get();
        Departement d = deprep.findById(departementId).get();
        e.setDepartement(d);
        enseigrep.save(e);
        log.info("enseignant "+e.getNom()+" "+e.getPrenom()+" assigné au departement "+d.getNomDepart());
		
	}

	@Override
	public int searchEnseignantBynomEtprenom(String nom, String prenom) {
		return enseigrep.searchEnseignantBynomEtprenom(nom, prenom);
	}
	
	@Override
	public int searchEnseignantByIdDepart(Integer id) {
		return enseigrep.searchEnseignantByIdDepartment(id);
	}

}