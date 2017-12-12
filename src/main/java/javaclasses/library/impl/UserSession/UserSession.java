package javaclasses.library.impl.UserSession;

import javaclasses.library.impl.user.User;

import java.util.Date;

public class UserSession {

    private long id;

    private Date date;

    private String token;

    private User user;

    public UserSession(Date date, String token, User user) {
        this.date = date;
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setId(long id) {
        this.id = id;
    }
}
