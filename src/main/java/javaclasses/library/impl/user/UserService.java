package javaclasses.library.impl.user;

import javaclasses.library.impl.UserSession.UserSessionService;

import javax.naming.AuthenticationException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;
import static javaclasses.library.impl.user.UserPermission.CREATE_USER;
import static javaclasses.library.impl.user.UserRole.ADMIN;

public class UserService {

    private final UserDAO userDAO;
    private final UserSessionService userSessionService;
    private MessageDigest MD5;


    public UserService(UserDAO userDAO, UserSessionService userSessionService)  {
        this.userDAO = userDAO;
        this.userSessionService = userSessionService;
        try {
            MD5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        createAdmin();
    }

    public void createUser(String securityToken, UserVO userVO) throws IllegalAccessException {

        checkArgument(!isNullOrEmpty(securityToken));
        checkUserPermission(securityToken, CREATE_USER);
        checkArgument(!isNullOrEmpty(userVO.getUsername()));
        checkArgument(!isNullOrEmpty(userVO.getPassword()));

        userDAO.newUser(new User(userVO.getUsername(), MD5.digest(userVO.getUsername().getBytes()), userVO.getRole()));
    }

    private void checkUserPermission(String securityToken, UserPermission permission) throws IllegalAccessException {
        final User user = userSessionService.getUserBySecurityToken(securityToken);
        if (!Arrays.asList(user.getRole().getPermissions()).contains(permission)){
            throw new IllegalAccessException("User needs permission " + permission.name());
        }
    }

    private void createAdmin(){
        userDAO.newUser(new User("admin", MD5.digest("password".getBytes()), ADMIN));
    }

    public String loginUser(String login, String password) throws AuthenticationException {
        checkArgument(!isNullOrEmpty(login));
        checkArgument(!isNullOrEmpty(password));

        User user = userDAO.findByUsername(login);
        checkNotNull(user);

        if (Arrays.equals(MD5.digest(password.getBytes()), (user.getPassword()))){
            return userSessionService.createSession(user);
        }

        throw new AuthenticationException("Invalid username or password.");
    }
}
