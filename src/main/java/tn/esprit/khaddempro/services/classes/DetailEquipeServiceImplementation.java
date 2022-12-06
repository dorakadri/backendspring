package tn.esprit.khaddempro.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.khaddempro.DAO.entities.DetailEquipe;
import tn.esprit.khaddempro.DAO.repository.DetailEquipe_repo;
import tn.esprit.khaddempro.services.interfaces.DetailEquipeService;


@Service
public class DetailEquipeServiceImplementation implements DetailEquipeService{

	@Autowired
	    DetailEquipe_repo detailEquipeRepository;

	    public List<DetailEquipe> getDetailEquipes(){
	        return detailEquipeRepository.findAll();
	    }
	    
	    public DetailEquipe saveDetailEquipe(DetailEquipe detailEquipe){
	        return detailEquipeRepository.save(detailEquipe);
	    }
	    
	    public List<DetailEquipe> saveDetailEquipes(List<DetailEquipe> detailEquipe){
	        return detailEquipeRepository.saveAll(detailEquipe);
	    }

	    public String deleteDetailEquipe(Integer idDetailEquipe){
	        detailEquipeRepository.deleteById(idDetailEquipe);
	        return "DetailEquipe supprimé !" +idDetailEquipe;
	    }
	    
	    public DetailEquipe upadateDetailEquipe(DetailEquipe detailEquipe){
	        DetailEquipe existingDetailEquipe = detailEquipeRepository.findById(detailEquipe.getIdDetailEquipe()).orElse(null);
	        existingDetailEquipe.setSalle(detailEquipe.getSalle());
	        existingDetailEquipe.setThematique(detailEquipe.getThematique());
	        existingDetailEquipe.setEquipe(detailEquipe.getEquipe());
	        return detailEquipeRepository.save(existingDetailEquipe);
	    }


	    public List<DetailEquipe> findByThematiqueLike(String thematique){
	    	
	        return detailEquipeRepository.findByThematiqueLike(thematique);
	    }
}
		
