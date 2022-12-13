package tn.esprit.khaddempro.services.classes;

import tn.esprit.khaddempro.DAO.repository.RoleDao;
import tn.esprit.khaddempro.DAO.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
