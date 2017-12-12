package javaclasses.library.impl.user;

public class User {

    private long id;

    private String username;

    private byte[] password;

    public User(String username, byte[] password) {
        this.username = username;
        this.password = password;
    }
}
