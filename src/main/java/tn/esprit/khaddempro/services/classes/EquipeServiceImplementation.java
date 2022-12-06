package tn.esprit.khaddempro.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.khaddempro.DAO.entities.DetailEquipe;
import tn.esprit.khaddempro.DAO.entities.Equipe;
import tn.esprit.khaddempro.DAO.entities.Etudiant;
import tn.esprit.khaddempro.DAO.repository.DetailEquipe_repo;
import tn.esprit.khaddempro.DAO.repository.Equipe_rep;
import tn.esprit.khaddempro.DAO.repository.EtudiantRepository;
import tn.esprit.khaddempro.services.interfaces.EquipeService;

@Service
public class EquipeServiceImplementation implements EquipeService {
@Autowired
Equipe_rep equiperep;
@Autowired
DetailEquipe_repo detailequiperep;
@Autowired
EtudiantRepository etudrep;

@Override
public List<Equipe> retrieveAllEquipes() {
	return (List<Equipe>) equiperep.findAll();
}

@Override
public Equipe addEquipe(Equipe e) {
	DetailEquipe de =detailequiperep.save(e.getEquipedetail());

	
	return equiperep.save(e);
}

@Override
public Equipe updateEquipe(Equipe e) {
	DetailEquipe de =detailequiperep.save(e.getEquipedetail());

	return equiperep.save(e);
}

@Override
public Equipe retrieveEquipe(Integer idEquipe) {
	return  equiperep.findById(idEquipe).get();

}

@Override
public void DeleteEquipe(Integer idEquipe) {
	equiperep.deleteById(idEquipe);
	
}

@Override
public Equipe affecterDetailsToEquipe(int IdEquipe,int IdDetailEquipe) {
	Equipe e= equiperep.findById(IdEquipe).get();
	DetailEquipe de=detailequiperep.findById(IdDetailEquipe).get();
	e.setEquipedetail(de);
	return equiperep.save(e);
}

@Override
public Etudiant assignEquipeToEtudiant(int idEquipe, int idEtudiant) {
     Etudiant e=etudrep.findById(idEtudiant).get();
     Equipe eq=equiperep.findById(idEquipe).get();
     eq.getEtudiants().add(e);
     equiperep.save(eq);
	return e;
}




}
