package javaclasses.library.impl;

import javaclasses.library.Library;
import javaclasses.library.impl.book.Book;
import javaclasses.library.impl.user.User;
import javaclasses.library.impl.user.UserDAO;
import javaclasses.library.impl.user.UserService;


/**
 * Represents implementation of library management system.
 */
public class LibraryImpl implements Library {

    private final UserService userService;
    private final UserDAO userDAO;

    public LibraryImpl(){
        userDAO = new UserDAO();
        userService = new UserService(userDAO);
    }

    @Override
    public void addBook(Book book) {

    }

    @Override
    public void borrowBook(String securityToken, Book book) {

    }

    @Override
    public void createUser(User user) {
        userService.createUser(user);
    }

    @Override
    public String loginUser() {
        return null;
    }

}
