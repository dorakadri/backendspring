package tn.esprit.khaddempro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.khaddempro.DAO.entities.Equipe;
import tn.esprit.khaddempro.DAO.entities.Projet;
import tn.esprit.khaddempro.modals.project;
import tn.esprit.khaddempro.services.interfaces.ProjetService;



@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200",exposedHeaders = {"Content-Disposition","Access-Control-Allow-Credentials"})

public class ProjetController {
	@Autowired
 ProjetService projetserv  ;
	
	
	
	@GetMapping("/displayallprojet")
	public List<Projet> displayProjet(){
		return projetserv.retrieveAllProjets();		
	}
	@GetMapping("/displayunivequipeprojet/{id}")
	public Projet displayProjetunivbyid(@PathVariable("id") int id){
		return projetserv.retrieveProjet(id);		
	}
	
	@GetMapping("/displayallprojet/{id}")
	public project displayProjetallbyid(@PathVariable("id") int id){
		return projetserv.retrieveProjetuniversityandequipe(id);		
	}
	
	 @PutMapping("Updateprojet/{idproject}")
	  @ResponseBody
	  public Projet updateProjet(@RequestBody Projet p , @PathVariable("idproject") int idprojet) {
		return projetserv.updateProjet(p, idprojet);
			}

	@PostMapping("addProjetprojet")
	public ResponseEntity<Integer>AddProjet(@RequestBody Projet Projet){
		int i =projetserv.addProjet(Projet);
		if( i != -1) {
			return new ResponseEntity<Integer>(i,HttpStatus.CREATED);
		}
		return new ResponseEntity<Integer>(-1,HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("deleteProjet/{id}")
	public  void removeProjet(@PathVariable("id") int id){
		projetserv.DeleteProjet(id);
	
	}

	@DeleteMapping("deleteequipe/{idproject}/{idequip}")
	public ResponseEntity<Integer> removeequipe (@PathVariable("idequip") int idequip, @PathVariable("idproject") int idprojet){
		projetserv.deleteequipe(idprojet, idequip);
		return new ResponseEntity<Integer>(1,HttpStatus.OK);
	
	}
	
	@PostMapping("equipetoprojet/{idequip}/{idprojet}")
	public void assignprojettoequipe(@PathVariable List<Integer> idequip,  @PathVariable("idprojet") int idprojet) {
		projetserv.assignEquipeToProjet(idequip,idprojet) ;
	}
	
	@GetMapping("/displayallequipe/{id}")
	public List<Integer> displayallequipebyid(@PathVariable("id") int id){
		return projetserv.getassignEquipeToProjet(id);		
	}
	
	
	
	@PostMapping("assignfile/{idfile}/{idproject}")
	public Integer assignfiletoproject(@PathVariable("idfile") int idfile, @PathVariable("idproject") int idprojet) {
		try {
			projetserv.assignfiletoproject(idfile,idprojet) ;
			return 1 ;
		} catch (Exception e) {
			return -1 ;
		}
		
	}
	
	
}
