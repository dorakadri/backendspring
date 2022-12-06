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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.khaddempro.DAO.entities.Equipe;
import tn.esprit.khaddempro.DAO.entities.Etudiant;
import tn.esprit.khaddempro.DAO.repository.Equipe_rep;
import tn.esprit.khaddempro.services.interfaces.EquipeService;


@RestController
@RequestMapping("/EquipeController")
@CrossOrigin(origins = "http://localhost:4200")
public class EquipeController {
	
	 @Autowired 
	 EquipeService equipeserv; 
	 Equipe_rep equiprep;
	 
	 @GetMapping("/displayEquipes")
	 public List<Equipe> getEquipes(){
		 return equipeserv.retrieveAllEquipes();
	 }
	 
 @GetMapping("/displayEquipeById/{id}")
	public Equipe displayEquipe(@PathVariable int id) {
		return equipeserv.retrieveEquipe(id);
	}
 

 
 @PostMapping("/addEquipe")
 @ResponseBody
 public Equipe addEquipe(@RequestBody Equipe eq) {
	 equipeserv.addEquipe(eq);
	 return eq; 
 }
 
 
 @PutMapping("/updateEquipe")
 public Equipe updateEquipe(@RequestBody Equipe eq ) {
	 return  equipeserv.updateEquipe(eq); 
 }
 
 @DeleteMapping("/deleteEquipe/{id}")
 public void DeleteEquipe(@PathVariable("id")int id ) {
	 equipeserv.DeleteEquipe(id);
 }
 
 
 @PutMapping("affecterDetailsToEquipe/{idEquipe}/{Iddetails}")
 public Equipe affecterDetailsToEquipe(@PathVariable("idEquipe") int IdEquipe,@PathVariable("Iddetails") int IdDetailEquipe) {
	 return equipeserv.affecterDetailsToEquipe(IdEquipe, IdEquipe);
 }
 
 @PutMapping("assignEquipeEtudiant/{idequipe}/{idetudiant}")
 public Etudiant assignEquipeToEtudiant(@PathVariable("idequipe") int idEquipe,@PathVariable("idetudiant") int idEtudiant) {
	 return equipeserv.assignEquipeToEtudiant(idEquipe, idEtudiant);
	 
 }
 
}
