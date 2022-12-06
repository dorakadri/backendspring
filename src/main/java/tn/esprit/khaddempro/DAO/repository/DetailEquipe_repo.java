package tn.esprit.khaddempro.DAO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.khaddempro.DAO.entities.DetailEquipe;


@Repository
public interface DetailEquipe_repo extends JpaRepository<DetailEquipe, Integer> {

    List<DetailEquipe> findByThematiqueLike(String thematique);

}
