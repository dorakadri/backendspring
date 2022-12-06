package tn.esprit.khaddempro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.khaddempro.DAO.entities.Enseignant;
import tn.esprit.khaddempro.services.interfaces.EnseignantService;


@RestController
@RequestMapping("/controllerEnseignant")
@CrossOrigin(origins = "*")
public class EnseignantController {
	
	  @Autowired
	  EnseignantService Enseigserv;
	 
	 
	  @GetMapping("/DisplayEnseignant")
	  public List<Enseignant> DisplayEnseignant() {
		  return Enseigserv.retrieveAllEnseignants();
	  }
	  

	  @GetMapping("/searchEnseignantBynomEtprenom/{nom}/{prenom}")
	  public int searchEnseignantBynomEtprenom(@PathVariable("nom") String nom, @PathVariable("prenom") String prenom){
		  return Enseigserv.searchEnseignantBynomEtprenom(nom, prenom);
	  }
	  
	   
	  @GetMapping("/DisplayEnseignantById/{idenseignant}")
	  public Enseignant displayEnseignantByID(@PathVariable("idenseignant") int idenseignant) {
		  return Enseigserv.retrieveEnseignant(idenseignant); 
		  }
	  
	  @PostMapping("/ajouterEnseignant")
	  public Integer addEnseignant(@RequestBody Enseignant e) {
		  e=Enseigserv.addEnseignant(e);
		  return  e.getIdenseignant() ;
	  }
	  
	  @PutMapping("/updateEnseignantById")
	  public Integer updateEnseignant(@RequestBody Enseignant e) {
		  e=Enseigserv.updateEnseignant(e);
		  return  e.getIdenseignant() ;
			}
	  
	  @DeleteMapping("/deletEnseignant/{idenseignant}")
	  public void deleteEnseignantById(@PathVariable("idenseignant") int idenseignant){ 
		  Enseigserv.removeEnseignant(idenseignant);
	   }
	  
	  
	  @GetMapping("filterEnseignantsBeginByName/{name}")
	  public List<Enseignant> allEnseignantsNameCommencePar(@PathVariable("name") String name){
		  return Enseigserv.getAllEnseignantBeginByNom(name);
	  }

	  
		@PutMapping("assignEnseignantToDepartement/{idenseignant}/{iddep}")
		public void assignEnseignantToDepartement( @PathVariable("idenseignant") Integer idenseignant, @PathVariable("iddep") Integer iddep) {
			Enseigserv.assignEnseignantToDepartement(idenseignant, iddep);
		}
		
		@GetMapping("/displayEnseignantByIdDepartment/{idenseignant}")
		  public int displayEnseignantByIdDepartment(@PathVariable("idenseignant") int idenseignant) {
			  return Enseigserv.searchEnseignantByIdDepart(idenseignant); 
			  }

}
