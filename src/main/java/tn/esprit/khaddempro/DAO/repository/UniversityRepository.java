package tn.esprit.khaddempro.DAO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.khaddempro.DAO.entities.Departement;
import tn.esprit.khaddempro.DAO.entities.Universite;

public interface UniversityRepository extends JpaRepository<Universite, Integer> {
 //   @Query("select u.departments from Universite u  where u.idUniv= ?1")
	//public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
    
    
    @Query (value="SELECT  departement.id_departement from departement where departement.id_departement not in (select universite_depart.depart_id_departement from universite_depart)",
    		 nativeQuery = true)
    List<Integer> getDepartementAffected();
    
    
}