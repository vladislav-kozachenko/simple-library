package javaclasses.library.impl.user;

public class User {

    private long id;

    private String username;

    private byte[] password;

    public User(String username, byte[] password) {
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setId(long id) {
        this.id = id;
    }
}
