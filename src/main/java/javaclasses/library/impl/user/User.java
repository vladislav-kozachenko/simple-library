package javaclasses.library.impl.user;

public class User {

    private long id;

    private String username;

    private byte[] password;

    private UserRole role;

    public User(String username, byte[] password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
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
