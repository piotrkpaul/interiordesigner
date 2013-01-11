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

/**
 * Date: 24.11.2012
 * Time: 22:51
 */
@Transactional
@Service("userDetailsService")
public class UserSecurityService implements UserDetailsService {

    @Autowired
    UserDAO userDAO;

    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        UserEntity userFromDatabase = userDAO.getByEmail(userEmail);

        if(userFromDatabase != null) {

            List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();

            if (userFromDatabase.getRole().equals("ROLE_ADMIN")) {
                roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                roles.add(new SimpleGrantedAuthority("ROLE_USER"));
            }
            else if (userFromDatabase.getRole().equals("ROLE_USER")) {
                roles.add(new SimpleGrantedAuthority("ROLE_USER"));
            }
            else {
                try {
                    throw new RoleNotFoundException("User has no role declared.");
                } catch (RoleNotFoundException e) {
                    e.printStackTrace();
                }
            }

            return new User(userFromDatabase.getEmail(), userFromDatabase.getPassword(), roles);
        }

        else {
            throw new UsernameNotFoundException("User with email : " + userEmail + " not found in database.");
        }
    }
}
