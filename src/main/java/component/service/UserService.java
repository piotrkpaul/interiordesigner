package component.service;

import component.dao.hibernate.UserDAO;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.RoleNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserService  {

    @Autowired
    private UserDAO userDAO;

    public void addUser(UserEntity user) {
        System.out.println(user.getEmail());
        userDAO.add(user);
    }

    public UserEntity getById(Integer uid) {
        return userDAO.getById(uid);
    }
    public List<UserEntity> getAllUsers() {
        return userDAO.getAll(new UserEntity());
    }
}
