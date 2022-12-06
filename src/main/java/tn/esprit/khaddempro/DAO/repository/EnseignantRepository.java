package tn.esprit.khaddempro.DAO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.khaddempro.DAO.entities.Enseignant;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant,Integer>{
	
	@Query("select e from Enseignant e where e.nom like %:prefixe%")
    List<Enseignant> getAllEnseignantsBeginByNom(@Param("prefixe") String prefixe);
	
	@Query("select e.idenseignant from  Enseignant e where e.nom like %?1 and e.prenom like %?2 ")
	int searchEnseignantBynomEtprenom(String nom ,String prenom );
	
	@Query(value="select e.departement_id_departement from  enseignant e where e.idenseignant = ?1", nativeQuery=true)
	int searchEnseignantByIdDepartment(int id );
	/*
	@Modifying
	@Query("update Etudiant e set e.departement.idDepart = ?2 where e.idEtudiant= ?1")
	public void assignEtudiantToDepartement (Integer etudiantId, Integer departementId) ;
	*/

}