package tn.esprit.khaddempro.services.interfaces;

import java.util.List;

import tn.esprit.khaddempro.DAO.entities.DetailEquipe;

public interface DetailEquipeService {
	 public List<DetailEquipe> getDetailEquipes();
	 public DetailEquipe saveDetailEquipe(DetailEquipe detailEquipe);
	 public List<DetailEquipe> saveDetailEquipes(List<DetailEquipe> detailEquipe);
	 public String deleteDetailEquipe(Integer idDetailEquipe);
	 public DetailEquipe upadateDetailEquipe(DetailEquipe detailEquipe);
	 List<DetailEquipe> findByThematiqueLike(String thematique);

}
