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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.khaddempro.DAO.entities.Departement;
import tn.esprit.khaddempro.DAO.entities.Etudiant;
import tn.esprit.khaddempro.services.interfaces.DepartmentService;



@RestController
@RequestMapping("DepartmentController")
@CrossOrigin
public class DepartmentController {

	@Autowired
	DepartmentService depserv ; 
	
	@GetMapping("displayalldepartment")
	public List<Departement> retrieveAllDepartements() {
		return depserv.retrieveAllDepartements();
	}

	@PostMapping("addDepartment")
	public Departement addDepartement(@RequestBody Departement d) {
		 depserv.addDepartement(d);
		return d;
	}

	@PutMapping("updatedepartment")
	@ResponseBody
	public Departement updateDepartement(@RequestBody Departement d) {
		depserv.updateDepartement(d);
		return d;
	}

	@GetMapping("displdepartmentbyid/{idDepart}")
	@ResponseBody
	public Departement retrieveDepartement( @PathVariable("idDepart") int idDepart) {
		return depserv.retrieveDepartement(idDepart);
	}

	@GetMapping("GetListOfEtudiantsByDepartment/{iddepartment}")
	List<Etudiant> getEtudiantsByDepartment(@PathVariable("iddepartment") Integer iddep){
		return depserv.getEtudiantsByDepartement(iddep);
	}
	
	@DeleteMapping("/deleteDepartment/{id}")
	 public void DeleteEquipe(@PathVariable("id")int id ) {
		depserv.DeleteDepartment(id);
	 }

	@GetMapping("/GetNbensperDepartment/{id}")
	  public int GetNbetdperDepartment(@PathVariable("id") int id) {
		  return depserv.GetNbrEnseignantInEveryDepartment(id); 
		  }
}
