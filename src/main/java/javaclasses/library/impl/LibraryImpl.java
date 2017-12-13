package javaclasses.library.impl;

import javaclasses.library.Library;
import javaclasses.library.impl.UserSession.UserSessionDAO;
import javaclasses.library.impl.UserSession.UserSessionService;
import javaclasses.library.impl.author.AuthorDAO;
import javaclasses.library.impl.author.AuthorService;
import javaclasses.library.impl.author.AuthorVO;
import javaclasses.library.impl.book.Book;
import javaclasses.library.impl.user.UserDAO;
import javaclasses.library.impl.user.UserService;
import javaclasses.library.impl.user.UserVO;

import javax.naming.AuthenticationException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Represents implementation of library management system.
 */
public class LibraryImpl implements Library {

    private final UserService userService;
    private final AuthorService authorService;
    private final AuthorDAO authorDAO;
    private final UserDAO userDAO;
    private final UserSessionService userSessionService;
    private final UserSessionDAO userSessionDAO;

    public LibraryImpl()  {
        userSessionDAO = new UserSessionDAO();
        userSessionService = new UserSessionService(userSessionDAO);
        userDAO = new UserDAO();
        userService = new UserService(userDAO, userSessionService);
        authorDAO = new AuthorDAO();
        authorService = new AuthorService(authorDAO, userService);
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
    public String loginUser(String login, String password) throws AuthenticationException {
        return userService.loginUser(login, password);
    }

    @Override
    public void addAuthor(String securityToken, AuthorVO author) throws IllegalAccessException {
        authorService.createAuthor(securityToken, author);
    }
}
