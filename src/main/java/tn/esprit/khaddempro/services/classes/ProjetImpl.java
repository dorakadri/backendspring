package tn.esprit.khaddempro.services.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.khaddempro.DAO.entities.Contrat;
import tn.esprit.khaddempro.DAO.entities.Departement;
import tn.esprit.khaddempro.DAO.entities.Equipe;
import tn.esprit.khaddempro.DAO.entities.FileEntity;
import tn.esprit.khaddempro.DAO.entities.Projet;
import tn.esprit.khaddempro.DAO.entities.Universite;
import tn.esprit.khaddempro.DAO.repository.Equipe_rep;
import tn.esprit.khaddempro.DAO.repository.FileRepository;
import tn.esprit.khaddempro.DAO.repository.Projet_repo;
import tn.esprit.khaddempro.modals.project;
import tn.esprit.khaddempro.services.interfaces.ProjetService;

@Service
@Transactional
@Slf4j
public class ProjetImpl implements ProjetService {
	
	@Autowired
	Projet_repo projetrep; 
	
	@Autowired
	Equipe_rep equiperep; 
	
	
	@Autowired
	FileRepository fileRep ;

	@Override
	public List<Projet> retrieveAllProjets() {
		return projetrep.findAll();
	}

	@Override
	public Integer addProjet(Projet p) {
		System.out.println(projetrep.findByNomProjet(p.getNomProjet()).isEmpty() );
	    if(projetrep.findByNomProjet(p.getNomProjet()).isEmpty()) {
	    	return projetrep.save(p).getIdProjet();
	    }
		return -1 ;
	}

	@Override
	public Projet updateProjet(Projet p , Integer idprojet) {
	//int file=	p.getFile().getId();
		
		FileEntity file  =	projetrep.findById(idprojet).get().getFile();
		if(file == null ) {
			 projetrep.save(p);
			 return projetrep.findById(p.getIdProjet()).get();
		}else {
			Integer id = file.getId();
			 projetrep.save(p);
			assignfiletoproject(id,p.getIdProjet());
			return projetrep.findById(p.getIdProjet()).get();
		}
				

	
		
		
	
	}

	@Override
	public  Projet retrieveProjet(Integer idProjet) {

	return  projetrep.findById(idProjet).get();
	}

	@Override
	public void DeleteProjet(Integer idProjet) {	
	projetrep.deleteById(idProjet);
	}

	@Override
	public void assignEquipeToProjet(List<Integer>idequipe, int  idprojet) {
	//	Projet projet = projetrep.findById(idprojet).get();
	//	Equipe equipe = equiperep.findById(idequipe).get();
	//	projet.getEquipes().add(equipe);
	
	//	projetrep.save(projet);
		////////////////////////////////////////////////////////////
		
		Projet projcet = projetrep.findById(idprojet).get();
		 List<Equipe> equipes=  projcet.getEquipes();
		 projcet.getEquipes().removeAll(equipes);
		 List <Equipe> Equipes = new ArrayList<>();
		 for (Integer i : idequipe) {
			 Equipe d=equiperep.findById(i).get();
			 Equipes.add(d);
			
		}


		 projcet.getEquipes().addAll(Equipes);
		log.info("adding department to university...");
		projetrep.save(projcet);
		log.info("added succesfuly...");
	}

	@Override
	public project retrieveProjetuniversityandequipe(Integer idProjet) {
		project pro =new project() ;
		Projet projet=  projetrep.findById(idProjet).get();
		pro.setClient(projet.getClient());
		pro.setDeadline(projet.getDeadline());
		pro.setDecription(projet.getDecription());
		pro.setNomProjet(projet.getNomProjet());
		pro.setIdProjet(projet.getIdProjet());
		pro.setEtat(projet.getEtat());
	   pro.setField(projet.getField());
	pro.setEquipes(projet.getEquipes().stream()
            .map(Equipe::getNomEquipe)
            .collect(Collectors.toList()));
	
		return pro  ;
	}

	@Override
	public List<Integer> getassignEquipeToProjet(Integer idprojet) {
		Projet projet = projetrep.findById(idprojet).get() ;
	 return projet.getEquipes().stream().map(Equipe :: getIdEquipe).collect(Collectors.toList()) ;
	}

	@Override
	public void deleteequipe(Integer idprojet, Integer idequipe) {
		Projet projet = projetrep.findById(idprojet).get() ;
		Equipe equipe = equiperep.findById(idequipe).get();
		projet.getEquipes().remove(equipe);
		projetrep.save(projet);
	
     
	}

	@Override
	public void assignfiletoproject(Integer file,Integer idpro) {
		Projet projet = projetrep.findById(idpro).get() ;
		
		projet.setFile(fileRep.findById(file).get());
		
	}
	
	

	

}
