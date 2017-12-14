package javaclasses.library.impl.user;

import javaclasses.library.impl.book.Book;

import java.util.ArrayList;
import java.util.List;

public class User {

    private long id;

    private String username;

    private byte[] password;

    private UserRole role;

    private List<Book> borrowedBooks;

    public User(String username, byte[] password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
        borrowedBooks = new ArrayList<>();
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

    public UserRole getRole() {
        return role;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
