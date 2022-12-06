package tn.esprit.khaddempro.DAO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.khaddempro.DAO.entities.Equipe;

public interface Equipe_rep  extends JpaRepository<Equipe,Integer> {
	@Query(value="SELECT * from equipe RIGHT JOIN equipe_etudiants ON equipe.id_equipe=equipe_etudiants.equipe_id_equipe RIGHT JOIN etudiant ON equipe_etudiants.etudiants_id_etudiant=etudiant.id_etudiant"
			,nativeQuery=true)
	public List<Equipe> getAllEquipe(); 

	
}


