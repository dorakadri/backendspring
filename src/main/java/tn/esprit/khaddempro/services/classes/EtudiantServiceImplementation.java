package tn.esprit.khaddempro.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.khaddempro.DAO.entities.Contrat;
import tn.esprit.khaddempro.DAO.entities.Departement;
import tn.esprit.khaddempro.DAO.entities.Equipe;
import tn.esprit.khaddempro.DAO.entities.Etudiant;
import tn.esprit.khaddempro.DAO.repository.ContratRepository;

import tn.esprit.khaddempro.DAO.repository.DepartmentRepository;
import tn.esprit.khaddempro.DAO.repository.Equipe_rep;
import tn.esprit.khaddempro.DAO.repository.EtudiantRepository;
import tn.esprit.khaddempro.services.interfaces.EtudiantService;


@Slf4j
@Service
public class EtudiantServiceImplementation implements EtudiantService {

	  @Autowired
		EtudiantRepository etudrep ;
	  @Autowired
	  DepartmentRepository deprep ;
	  @Autowired
	  ContratRepository   contrep;
	  @Autowired
	  Equipe_rep equiprep;
	    
	@Override
	public List<Etudiant> retrieveAllEtudiants() {
		 return etudrep.findAll();
		
	}

	@Override
	public Etudiant addEtudiant(Etudiant e) {
		/*try {
		log.info(" adding student ... ");
		etudrep.save(e);
	    log.info("student added successfuly");
		}catch(exception exp) {
       log.info("test1"+exp.getstacktrace());
		}*/
		
		return etudrep.save(e);
	}

	@Override
	public Etudiant updateEtudiant(Etudiant e) {
	
		log.info(""+e.getIdEtudiant()+"Data before saving");
	      log.info("saving new values ...");
	    
	    	  log.info("save"+e);
	    	
	    	  
	    	  return etudrep.save(e);
 
	}

	@Override
	public Etudiant retrieveEtudiant(Integer idEtudiant) {
		return etudrep.findById(idEtudiant).get();
	}

	@Override
	public void removeEtudiant(Integer idEtudiant) {
		 etudrep.deleteById(idEtudiant);
		   // etudrep.delete(etudrep.findById(Etudiant));
	}

	
	@Override
	public List<Etudiant> getAllEtudiantsBeginByNomE(String name) {
		log.info(""+name);
		return etudrep.getAllEtudiantsBeginByNomE(name);
	}

	@Override
	public Etudiant getEtudiantByNomE(String name) {
		log.info("resultat de recherche :"+etudrep.getEtudiantByNomE(name));
		return etudrep.getEtudiantByNomE(name);
		
	}


	@Override
	public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
		Etudiant e = etudrep.findById(etudiantId).get();
      Departement d = deprep.findById(departementId).get();
      e.setDepartement(d);
      etudrep.save(e);
      log.info("etudiant "+e.getPrenomE()+" "+e.getNomE()+" assigné au departement "+d.getNomDepart());
	}

	@Override
	public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
		int idetudiant=etudrep.searchEtudiantBynomEtprenom(nomE, prenomE);
		Etudiant e =etudrep.findById(idetudiant).get();
		ce.setEtudiant(e);
		contrep.save(ce);
		return ce;
	}

	@Override
	public int searchEtudiantBynomEtprenom(String nom, String prenom) {
		return etudrep.searchEtudiantBynomEtprenom(nom, prenom);
	}

	@Override
	public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
		e= etudrep.save(e);
		Contrat c =contrep.getById(idContrat);
		Equipe eq=equiprep.getById(idEquipe);
		c.setEtudiant(e);
		eq.getEtudiants().add(e);
	contrep.save(c);
	equiprep.save(eq);

		return e;
		
	}

	@Override
	public Etudiant addAndAssignEtudiantToEquipe(Etudiant e, Integer idEquipe)  {

		Etudiant etud = etudrep.save(e);
		Equipe eq=equiprep.findById(idEquipe).get();
		etud.getEquipe().add(eq);
		return etudrep.save(etud);

	}
	@Override
	public void assignEtudiantToEquipe(Integer idEquipe, Integer idEtudiant) {
		Etudiant Etudiant = etudrep.findById(idEtudiant).get();
		Equipe equipe = equiprep.findById(idEquipe).get();
		Etudiant.getEquipe().add(equipe);

		etudrep.save(Etudiant);

	}

	@Override
	public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
		
	 return etudrep.findEtudiantsByDepId(idDepartement);
	}
	}
