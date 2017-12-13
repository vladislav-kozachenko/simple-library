package javaclasses.library.impl.UserSession;

import javaclasses.library.impl.user.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class UserSessionService {

    private final UserSessionDAO userSessionDAO;

    public UserSessionService(UserSessionDAO userSessionDAO) {
        this.userSessionDAO = userSessionDAO;
    }

    public String createSession(User user){
        UserSession session = newSession(user);
        userSessionDAO.createSession(session);
        return session.getToken();
    }

    private UserSession newSession(User user)  {
        Date date = new Date(System.currentTimeMillis());
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String token = user.getUsername() + date.toString();
        byte[] digestToken = md5.digest(token.getBytes());
        String securedToken = new String(digestToken);

        return new UserSession(date, securedToken, user);
    }

    public User getUserBySecurityToken(String securityToken) throws IllegalAccessException {
        return userSessionDAO.getUserByToken(securityToken);
    }
}
