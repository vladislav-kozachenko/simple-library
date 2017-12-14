package javaclasses.library.impl.user;

import javaclasses.library.impl.book.Book;

import java.util.ArrayList;
import java.util.List;

public class UserVO {

    private UserID id;

    private UserName username;

    private String password;

    private UserRole role;


    public UserVO(UserName username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserID getId() {
        return id;
    }

    public UserName getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(UserID id) {
        this.id = id;
    }

    public UserRole getRole() {
        return role;
    }
}
