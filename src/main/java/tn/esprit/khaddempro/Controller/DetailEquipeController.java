package tn.esprit.khaddempro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.khaddempro.DAO.entities.DetailEquipe;
import tn.esprit.khaddempro.services.interfaces.DetailEquipeService;

@RestController
@RequestMapping("/DetailEquipeController")
public class DetailEquipeController {
	
	  @Autowired
	    DetailEquipeService detailEquipeService;

	    //creating a get mapping that retrieves all the detailEquipes detail from the database
	    @GetMapping("/detailEquipes")
	    private List<DetailEquipe> getAlldetailEquipes() {
	        return detailEquipeService.getDetailEquipes();
	    }

	    //creating a get mapping that retrieves the detail of a specific detailEquipe
	    @PostMapping("/AddDetailEquipe")
	    public DetailEquipe addDetailEquipe (@RequestBody DetailEquipe detailEquipe){
	        return detailEquipeService.saveDetailEquipe(detailEquipe);
	    }
	    @PostMapping("/AddDetailEquipes")
	    public List<DetailEquipe> addDetailEquipes (@RequestBody List<DetailEquipe> detailEquipes){
	        return detailEquipeService.saveDetailEquipes(detailEquipes);
	    }
	    @PutMapping("/UpdateDetailEquipe")
	    public DetailEquipe updateDetailEquipe (@RequestBody DetailEquipe detailEquipe){
	        return detailEquipeService.upadateDetailEquipe(detailEquipe);
	    }

	    @DeleteMapping("/DeleteDetailEquipe/{idDetailEquipe}")
	    public String deleteDetailEquipe (@PathVariable int idDetailEquipe){
	        return detailEquipeService.deleteDetailEquipe(idDetailEquipe);
	    }


	    @GetMapping("/findByThematique/{thematique}")
	    public List<DetailEquipe> findByThematique(@PathVariable("thematique") String thematique){
	        return detailEquipeService.findByThematiqueLike(thematique);
	    }

}
