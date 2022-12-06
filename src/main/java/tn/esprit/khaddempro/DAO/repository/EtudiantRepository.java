package tn.esprit.khaddempro.DAO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.khaddempro.DAO.entities.Etudiant;

@Repository
public interface EtudiantRepository  extends JpaRepository<Etudiant,Integer>{


	@Query(value="SELECT  * from etudiant LEFT JOIN equipe_etudiants ON etudiant.id_etudiant=equipe_etudiants.etudiants_id_etudiant"
			+ "  LEFT JOIN equipe ON equipe_etudiants.equipe_id_equipe=equipe.id_equipe "
			,nativeQuery=true)
	public List<Etudiant> getAllEtudiant();
	public Etudiant getEtudiantByNomE(String name);
	
	@Query("select e from Etudiant e where e.nomE like %:prefixe%")
    List<Etudiant> getAllEtudiantsBeginByNomE(@Param("prefixe") String prefixe);
	
	@Query("select e.idEtudiant from  Etudiant e where e.nomE= ?1 and e.prenomE= ?2 ")
	int searchEtudiantBynomEtprenom(String nom ,String prenom );
	/*
	@Modifying
	@Query("update Etudiant e set e.departement.idDepart = ?2 where e.idEtudiant= ?1")
	public void assignEtudiantToDepartement (Integer etudiantId, Integer departementId) ;
	*/
	/////////////////////////MTEEE3 firas/////////////////
	
	//Get idetudiant par nom et prenom 
	@Query("SELECT e.idEtudiant FROM Etudiant e WHERE e.nomE=:nomE AND e.prenomE=:prenomE")
	int getIdEtudiant(@Param("nomE") String nomE, @Param("prenomE") String prenomE);
	
	@Modifying
	//@Query(value="update etudiant set departement_id_depart :id_departement where etudiant.id_etudiant :id_etudiant " ,nativeQuery = true) :Native Sql
	@Query("update Etudiant e set e.departement.idDepart =:id_departement where e.idEtudiant =:id_etudiant " )
	public void assignEtudiantToDepartement (@Param("id_etudiant") Integer etudiantId, @Param("id_departement") Integer departementId) ;
	
	@Modifying
	@Query(value = "INSERT INTO equipe_etudiants(equipes_id_equipe, etudiants_id_etudiant) VALUES ( ?1 , ?2 )", nativeQuery = true)
	public void addEquipeEtudiant(Integer idEq, Integer idEt );
	
	//Get list of students by department id
	@Query(value="SELECT * FROM etudiant WHERE etudiant.departement_id_depart= ?1", nativeQuery=true)
	public List<Etudiant> findEtudiantsByDepId(Integer idDep);
}
