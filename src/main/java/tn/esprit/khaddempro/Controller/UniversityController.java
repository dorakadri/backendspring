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
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.khaddempro.DAO.entities.Departement;
import tn.esprit.khaddempro.DAO.entities.Universite;
import tn.esprit.khaddempro.services.interfaces.UniversiteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("UniversityController")
public class UniversityController {

	@Autowired
	UniversiteService univserv; 
	 

@GetMapping("displayUniversities")
public List<Universite> retrieveAllUniversites() {
	return univserv.retrieveAllUniversites();

}

@GetMapping("/DisplayUniversitiesById/{id}")
public Universite displayUniversitiesByID(@PathVariable("id") int id) {
	  
	  return univserv.getUniversiteById(id);
	  }

@PostMapping("/addUniversity")
public Integer  addUniversite(@RequestBody Universite u) {
u=univserv.addUniversite(u);
return u.getIdUniv();
}

@PutMapping("updateUniversity")
public Universite updateUniversity(@RequestBody Universite u) {
	 return univserv.updateUniversite(u);
}

@GetMapping("displayUniversityBYId/{idUniversity}")
public Universite retrieveUniversite(@PathVariable("idUniversity") Integer idUniversite) {
	return univserv.retrieveUniversite(idUniversite);
}

@PutMapping("assignuniversityToDepartment/{idUniv}/{idDepart}")
public void assignUniversiteToDepartement(@PathVariable("idUniv") int idUniv, @PathVariable List< Integer> idDepart) {
	univserv.assignUniversiteToDepartement(idUniv, idDepart);
}

@GetMapping("DetDepatmentByUniversity/{iduniv}")
public List<Departement> retrieveDepartementsByUniversite(@PathVariable("iduniv") Integer idUniversite){
	return univserv.retrieveDepartementsByUniversite( idUniversite);
}

@DeleteMapping("/deleteuniversity/{id}")
public ResponseEntity<String> remove(@PathVariable("id") int id){
	univserv.removeUniver(id);
	return new ResponseEntity<String>(HttpStatus.OK);
 }
@GetMapping("/departementAffected")
public List<Departement> getDepartementAffected(){
	return univserv.getDepartementAffected();
}


}
