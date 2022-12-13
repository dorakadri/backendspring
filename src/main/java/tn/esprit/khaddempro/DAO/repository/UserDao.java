package tn.esprit.khaddempro.DAO.repository;

import tn.esprit.khaddempro.DAO.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
