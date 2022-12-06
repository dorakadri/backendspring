package tn.esprit.khaddempro.DAO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.khaddempro.DAO.entities.Departement;
import tn.esprit.khaddempro.DAO.entities.Etudiant;

@Repository
public interface DepartmentRepository extends JpaRepository<Departement, Integer> {

	@Query("select d.etudiants from Departement d where d.idDepart =?1")
	List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);
	

	@Query(value="select count(*) from  enseignant e where e.departement_id_departement = ?1", nativeQuery=true)
	int GetNbrEnseignInEveryDepartment(int id );


}