package tn.esprit.khaddempro.DAO.repository;

import tn.esprit.khaddempro.DAO.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
