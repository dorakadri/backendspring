package tn.esprit.khaddempro.DAO.repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.khaddempro.DAO.entities.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Integer>{

//	@Modifying
//	@Query(value = "update contrat c set c.etudiant_id_etudiant=(select id_etudiant from etudiant e where e.nomE=:nomE and e.prenomE=\"firas\" LIMIT 1) where c.id_contrat=:#{#contrat.idContrat} ;", nativeQuery = true)
//	void affectContratToEtudiant (@Param("contrat") Contrat contrat, @Param("nomE") String nomE);
	
	//retourner le nombre de contrat actifs pour l'étudiant
//	@Query("SELECT Count(*) FROM Contrat WHERE Contrat.etudiant.idEtudiant=(SELECT idEtudiant from Etudiant WHERE Etudiant.nomE=:nomE AND Etudiant.prenomE=:prenomE LIMIT 1)")
//	int nbrContratEtudiantByName(@Param("nomE") String nomE ,@Param("prenomE") String prenomE );
	
	//retourner le nombre de contrat actifs pour l'étudiant ***!!!!!!!! not working in jpql
	@Query(value="SELECT COUNT(*) FROM contrat WHERE contrat.etudiant_id_etudiant= ?1 AND archive=false ", nativeQuery=true)
	public int nbrContratEtudiantByStudentId(Integer idE);
		

	//affecter un contrat à un étudiant
	@Modifying
	@Query("UPDATE Contrat c set c.etudiant.idEtudiant=:idE WHERE c.idContrat=:idC")
	void affectContratToEtudiant(@Param("idE") Integer idE, @Param("idC") Integer idC);
	
	
	@Query(value="SELECT SUM(montant_contrat), specialite FROM contrat WHERE archive=false AND date_debut_contrat> ?1 AND date_fin_contrat< ?2 GROUP BY (specialite) ", nativeQuery=true)
	public List<List<String>> getChiffreAffaireEntreDeuxDate(Timestamp startDate, Timestamp endDate);

	@Query(value="SELECT COUNT(*) FROM contrat WHERE archive=false AND date_debut_contrat> ?1 AND date_fin_contrat< ?2 ", nativeQuery=true)
	public Integer nbContratsValides(Timestamp startDate, Timestamp endDate);

	@Query(value="SELECT * FROM contrat WHERE date_fin_contrat = \'2022-11-12\'" , nativeQuery=true)//new Date()+15
	public List<String> retrieveContrats1(Timestamp dateMax);
	
	@Query(value="SELECT * FROM contrat WHERE date_fin_contrat <= ?1" , nativeQuery=true)//new Date()+14
	public List<String> retrieveContrats2(Timestamp dateMax);
	
	@Query(value="UPDATE contrat c  SET c.archive = true WHERE c.id_contrat= ?1 AND date_fin_contrat= ?2" , nativeQuery=true)//new Date()
	public void archiverContrats(int idC, Timestamp date);
}

//+ "(select idEtudiant from Etudiant where e.nomE=:nomE and e.prenomE=:prenomE) "
//update contrat c set c.etudiant_id_etudiant=(select id_etudiant from etudiant e where e.nomE="mansouri" and e.pre
