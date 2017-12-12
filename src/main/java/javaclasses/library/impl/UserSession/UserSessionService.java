package javaclasses.library.impl.UserSession;

import javaclasses.library.impl.user.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class UserSessionService {

    public String createSession(User user){
        return newSession(user).getToken();
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

}
