package javaclasses.library.impl.user;

import javaclasses.library.impl.book.Book;

import java.util.ArrayList;
import java.util.List;

public class User {

    private UserID id;

    private UserName username;

    private byte[] password;

    private UserRole role;

    private List<Book> borrowedBooks;

    public User(UserName username, byte[] password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
        borrowedBooks = new ArrayList<>();
    }

    public UserID getId() {
        return id;
    }

    public UserName getUsername() {
        return username;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setId(UserID id) {
        this.id = id;
    }

    public UserRole getRole() {
        return role;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
