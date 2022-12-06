package tn.esprit.khaddempro.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.khaddempro.DAO.entities.FileEntity;


@Repository
public interface FileRepository extends  JpaRepository <FileEntity, Integer>{

}
