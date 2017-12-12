package javaclasses.library.impl;

import javaclasses.library.Library;
import javaclasses.library.impl.book.Book;
import javaclasses.library.impl.user.UserDAO;
import javaclasses.library.impl.user.UserService;
import javaclasses.library.impl.user.UserVO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Represents implementation of library management system.
 */
public class LibraryImpl implements Library {

    private final UserService userService;
    private final UserDAO userDAO;

    public LibraryImpl()  {
        userDAO = new UserDAO();
        userService = new UserService(userDAO);
    }

    @Override
    public void addBook(String securityToken, Book book) {

    }

    @Override
    public void borrowBook(String securityToken, Book book) {

    }

    @Override
    public void createUser(String securityToken, UserVO user) {
        userService.createUser(securityToken, user);
    }

    @Override
    public String loginUser() {
        return null;
    }

}
