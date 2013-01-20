package component.service;

import component.dao.hibernate.UserDAO;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserService  {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    protected AuthenticationManager authenticationManager;

    public void addUser(UserEntity user) {
        userDAO.add(user);
    }
    public void updateUser(UserEntity userEntity, HttpServletRequest request) {
        userEntity.setPassword(this.stringToSha(userEntity.getPassword()));
        userDAO.update(userEntity);
        authenticateUserAndSetSession(userEntity, request);
    }

    public UserEntity getById(Integer uid) {
        return userDAO.getById(uid);
    }

    public UserEntity getByEmail(String email) {
        return userDAO.getByEmail(email);
    }

    public List<UserEntity> getAllUsers() {
        return userDAO.getAll(new UserEntity());
    }

    /* Returnes UserEntity, when authorizing from REST */
    public UserEntity getCredentials(String email, String password) {
        UserEntity authUser = userDAO.getByEmail(email);

        if(authUser!=null && authUser.getPassword().equals(password)) {
            return authUser;
        }
        else {
            return new UserEntity();
        }
    }


    public boolean checkIfExist(String email) {
        if(userDAO.getByEmail(email)!=null) {
           return true;
        } else {
          return false;
        }
    }

    public UserEntity createNewUserAndAuthenticate(UserEntity user, HttpServletRequest request, boolean createSession) {

        /* Generate timestamp of registration */
        Timestamp regDate = new Timestamp(new java.util.Date().getTime());
        user.setRegistrationDate(regDate);

        /* SHA-1 from plain text password */
        user.setPassword(this.stringToSha(user.getPassword()));

        /* List of authority */
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        user.setRole("ROLE_USER");

        /* Actual database save */
        this.addUser(user);

        if(createSession) {
        /* Loging user in, and redirecting to user view */
            authenticateUserAndSetSession(user, request);
        }
        return user;
    }


    /* Utilities */
    private void authenticateUserAndSetSession(UserEntity user, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());

        request.getSession();

        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }

    /* SHA-1 from plain text password */
    private String stringToSha(String password) {
        return new ShaPasswordEncoder().encodePassword(password, null);
    }


}
