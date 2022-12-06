package tn.esprit.khaddempro.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.khaddempro.DAO.entities.Contrat;
import tn.esprit.khaddempro.services.interfaces.ContratService;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ContratApi")
@RestController
public class ContratController {

	@Autowired
	ContratService contratService;
	
	@GetMapping("/getAll")
	public List <Contrat> displayAllContrats()
	{
		return contratService.retrieveAllContrats();
	}
	
	@PostMapping("/post")
	public Contrat addContrat(@RequestBody Contrat c) {
		return contratService.addContrat(c);
	}

	@PutMapping("/update")
	public Contrat updateContrat(@RequestBody Contrat c) {
		return contratService.updateContrat(c);
	}

	@GetMapping("/get/{id}")
	public Contrat retrieveContrat(@PathVariable("id") Integer idContrat) {
		return contratService.retrieveContrat(idContrat);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeContrat(@PathVariable("id") Integer idContrat) {
		contratService.removeContrat(idContrat);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PostMapping("/affectContratToEtudiant")
	ResponseEntity<String> affectContratToEtudiant (@RequestBody Contrat ce,@RequestParam String nomE,@RequestParam String prenomE) {
		Contrat c=contratService.affectContratToEtudiant(ce, nomE, prenomE);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@GetMapping("/getChiffreAffaire")
	public ResponseEntity<String> getChiffreAffaireEntreDeuxDate(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
		String str="";
		List<List<String>> listOfObjects= contratService.getChiffreAffaireEntreDeuxDate(startDate, endDate);
		for (List<String> list : listOfObjects) {
			str+=("Pour un contrat dont la spécialité est "+list.get(1)+": "+list.get(0) +" ");
		}
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	
	@GetMapping("/getNbContratsValides")
	public ResponseEntity<String> getNbContratsValidesEntreDeuxDate(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
		int nbrContrat= contratService.nbContratsValides(startDate, endDate);
		return new ResponseEntity<String>(Integer.toString(nbrContrat), HttpStatus.OK);
	}
	
	
}

