package tn.esprit.khaddempro.services.classes;


import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.khaddempro.DAO.entities.Contrat;
import tn.esprit.khaddempro.DAO.repository.ContratRepository;
import tn.esprit.khaddempro.DAO.repository.EtudiantRepository;
import tn.esprit.khaddempro.services.interfaces.ContratService;



@Service
@Transactional
public class ContratServiceImp implements ContratService{

	@Autowired
	ContratRepository contratRep;
	
	@Autowired
	EtudiantRepository etudiantRep;
	
	@Override
	public List<Contrat> retrieveAllContrats() {
		return contratRep.findAll();
	}

	@Override
	public Contrat updateContrat(Contrat ce) {
		Contrat c= new Contrat();
		if((ce.getEtudiant()).getNomE()!=""&&(ce.getEtudiant()).getPrenomE()!=""&&(ce.getEtudiant()).getDate_naissance()!=null) {
			etudiantRep.save(ce.getEtudiant());
			c= contratRep.save(ce);
		}else {
			ce.setEtudiant(null);
			c= contratRep.save(ce);
		}
		return c;
	}

	@Override
	public Contrat addContrat(Contrat ce) {
		Contrat c= new Contrat();
		if((ce.getEtudiant()).getNomE()!=""&&(ce.getEtudiant()).getPrenomE()!=""&&(ce.getEtudiant()).getDate_naissance()!=null) {
			etudiantRep.save(ce.getEtudiant());
			c= contratRep.save(ce);
		}else {
			ce.setEtudiant(null);
			c= contratRep.save(ce);
		}
		return c;
	}

	@Override
	public Contrat retrieveContrat(Integer idContrat) {
		return contratRep.findById(idContrat).get();
	}

	@Override
	public void removeContrat(Integer idContrat) {
		contratRep.deleteById(idContrat);
	}

	@Override
	public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
		//get etudiant par nom et prenom 
		int idE= etudiantRep.getIdEtudiant(nomE, prenomE);
		
		//vérifier le nombre de contrat actifs pour cet etudiant 
		if(contratRep.nbrContratEtudiantByStudentId(idE) <=5) {
			//affecter le contrat à l'étudiant
			contratRep.affectContratToEtudiant(idE, ce.getIdContrat());
		}

		
		return ce ;
	}

	@Override
	public List<List<String>> getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
		System.out.println(startDate +"   "+ endDate);
		java.sql.Timestamp sqlStartDate = new java.sql.Timestamp(startDate.getTime());
		System.out.println(sqlStartDate);
		java.sql.Timestamp sqlEndDate = new java.sql.Timestamp(endDate.getTime());
		System.out.println(sqlEndDate);
		List<List<String>> listOfObjects= contratRep.getChiffreAffaireEntreDeuxDate(sqlStartDate, sqlEndDate);
		System.out.println(listOfObjects.toString());
		//pour tester dans le console 
		for (List<String> list : listOfObjects) {
			System.out.println("Pour un contrat dont la spécialité est "+list.get(1)+": "+list.get(0));
		}
		return listOfObjects;
	}

	@Override
	public Integer nbContratsValides(Date startDate, Date endDate) {
		System.out.println(startDate +"   "+ endDate);
		java.sql.Timestamp sqlStartDate = new java.sql.Timestamp(startDate.getTime());
		System.out.println(sqlStartDate);
		java.sql.Timestamp sqlEndDate = new java.sql.Timestamp(endDate.getTime());
		System.out.println(sqlEndDate);
		int nbrc=contratRep.nbContratsValides(sqlStartDate, sqlEndDate);
		System.out.println(nbrc);
		return contratRep.nbContratsValides(sqlStartDate, sqlEndDate);
	}
	
	//@Scheduled(cron = "*/20 * * * * *")
	@Override
	public void retrieveAndUpdateStatusContrat() {
		Date currentDate = new Date();
		System.out.println("currentDate= "+ currentDate);
		java.sql.Timestamp sqlCurrentDate = new java.sql.Timestamp(currentDate.getTime());
		System.out.println(sqlCurrentDate); 
		
		Date fifteenDayFromCurrentDate = new Date(currentDate.getTime() + Duration.ofDays(15).toMillis());
		System.out.println("fifteenDayFromCurrentDate= "+fifteenDayFromCurrentDate);
		java.sql.Timestamp fifteenDayFromCurrentDateSqlDate = new java.sql.Timestamp(fifteenDayFromCurrentDate.getTime());
		System.out.println("sqlDate= "+fifteenDayFromCurrentDateSqlDate);
				
		System.out.println(contratRep.retrieveContrats1(fifteenDayFromCurrentDateSqlDate));
		
		Date fourteenDayFromCurrentDate = new Date(currentDate.getTime() + Duration.ofDays(14).toMillis());
		System.out.println("fourteenDayFromCurrentDate= "+fourteenDayFromCurrentDate);
		java.sql.Timestamp fourteenDayFromCurrentDateSqlDate = new java.sql.Timestamp(fourteenDayFromCurrentDate.getTime());
		System.out.println("sqlDate= "+fourteenDayFromCurrentDateSqlDate);
		
		System.out.println(contratRep.retrieveContrats2(fourteenDayFromCurrentDateSqlDate));
		
//		contratRep.archiverContrats(1, sqlCurrentDate);
		
	}

}

