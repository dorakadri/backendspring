
package tn.esprit.khaddempro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.khaddempro.DAO.entities.Etudiant;
import tn.esprit.khaddempro.services.interfaces.EquipeService;
import tn.esprit.khaddempro.services.interfaces.EtudiantService;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/controllerEtudiant")

public class EtudiantController {


    @Autowired
    EtudiantService etudserv;
    @Autowired
    EquipeService equipeserv;


    @GetMapping("/DisplayStudents")
    public List<Etudiant> DisplayStudents() {
        return etudserv.retrieveAllEtudiants();
    }


    @GetMapping("/searchEtudiantByNomEtPrenom/{nom}/{prenom}")
    public int searchEtudiantBynomEtprenom(@PathVariable("nom") String nom, @PathVariable("prenom") String prenom) {
        return etudserv.searchEtudiantBynomEtprenom(nom, prenom);
    }


    @GetMapping("/DisplayEtudiantById/{id}")
    public Etudiant displayEtudiantByID(@PathVariable("id") int id) {

        return etudserv.retrieveEtudiant(id);
    }

    @PostMapping("/ajouterEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        e = etudserv.addEtudiant(e);
        return e;
    }

    @PutMapping("/updateStudentById")
    public Etudiant updateStudent(@RequestBody Etudiant e) {
        return etudserv.updateEtudiant(e);
    }

    @DeleteMapping("/deletestudent/")
    public void deleteStudentById(@RequestParam Integer id) {
        etudserv.removeEtudiant(id);
    }

  /*
  @GetMapping("existenceByName/{name}")
 
  public Etudiant testExistEtudiantByname(@PathVariable("name") String name) {
	  return etudserv.getEtudiantByNomE(name); 
  }*/

    @GetMapping("filterEtudiantsBeginByName/{name}")
    public List<Etudiant> allEtudiantsNameCommencePar(@PathVariable("name") String name) {
        return etudserv.getAllEtudiantsBeginByNomE(name);
    }


    @PostMapping("assignetudianttodepartment/{idet}/{iddep}")
    public ResponseEntity<Integer> assignEtudiantToDepartement(@PathVariable("idet") Integer idet, @PathVariable("iddep") Integer iddep) {
        etudserv.assignEtudiantToDepartement(idet, iddep);
        return new ResponseEntity<Integer>(1, HttpStatus.OK);
    }
	/*
	@PutMapping("assignContratToEtudiant/{nom}/{prenom}")
	public Contrat assignEtudiantToDepartement( @RequestBody Contrat ce , @PathVariable("nom") String nom, @PathVariable("prenom") String prenom) {
	return etudserv.affectContratToEtudiant(ce,nom, prenom);
	}
	 /*
	@PutMapping("assignEtudiantToContratEtEquipe/{idcontrat}/{idEquipe}")
	public Etudiant  addAndAssignEtudiantToEquipeAndContract(@ RequestBody Etudiant e ,@PathVariable("idcontrat") Integer idContrat,@PathVariable("idEquipe") Integer idEquipe) {
		return etudserv.addAndAssignEtudiantToEquipeAndContract(e, idContrat, idEquipe);
	}*/

    @PostMapping("assignEtudiantToEquipe/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipe(@RequestBody Etudiant e, @PathVariable("idEquipe") Integer idEquipe) {
        return etudserv.addAndAssignEtudiantToEquipe(e, idEquipe);
    }
    @PostMapping("assignEtudiantEquipe/{idEquipe}/{idEtudiant}")
    public void voidAssignEtudiantToEquipe(@PathVariable("idEquipe") Integer idEquipe, @PathVariable("idEtudiant") Integer idEtudiant) {
        etudserv.assignEtudiantToEquipe(idEquipe, idEtudiant);
    }



}