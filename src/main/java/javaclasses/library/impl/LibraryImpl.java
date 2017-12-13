package javaclasses.library.impl;

import javaclasses.library.Library;
import javaclasses.library.impl.UserSession.UserSessionDAO;
import javaclasses.library.impl.UserSession.UserSessionService;
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
    private final UserSessionService userSessionService;
    private final UserSessionDAO userSessionDAO;

    public LibraryImpl()  {
        userSessionDAO = new UserSessionDAO();
        userSessionService = new UserSessionService(userSessionDAO);
        userDAO = new UserDAO();
        userService = new UserService(userDAO, userSessionService);
    }

    @Override
    public void addBook(String securityToken, Book book) {

    }

    @Override
    public void borrowBook(String securityToken, Book book) {

    }

    @Override
    public void createUser(String securityToken, UserVO user) throws IllegalAccessException {
        userService.createUser(securityToken, user);
    }

    @Override
    public String loginUser() {
        return null;
    }

}
