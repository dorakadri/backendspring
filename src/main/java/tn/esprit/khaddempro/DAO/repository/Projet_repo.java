package tn.esprit.khaddempro.DAO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.khaddempro.DAO.entities.Etudiant;
import tn.esprit.khaddempro.DAO.entities.Projet;

@Repository
public interface Projet_repo extends JpaRepository<Projet, Integer> {
	
	
	@Modifying
	@Query(value="DELETE FROM projet_equipes WHERE projets_id_projet=?1 and projet_equipes.equipes_id_equipe=?2 ",nativeQuery = true )
	void deleteequipe(Integer idprojet,Integer idequipe);
	
	List<Projet> findByNomProjet(String nomProjet);
	

	
	
	
	
	
 
}