package javaclasses.library;

import javaclasses.library.impl.book.Book;
import javaclasses.library.impl.user.UserVO;

import javax.naming.AuthenticationException;

/**
 * Represents library management system.
 *
 * @author Kozachenko
 */
public interface Library {

    /**
     * Adds new book to book storage.
     * @param book is the book may be added.
     */
    void addBook(String securityToken, Book book);

    /**
     * Assign book that may be borrowed to the user that needs to borrow it.
     * @param securityToken unique security token may be used to get user and check if the user is logged in.
     * @param book is the book that may be borrowed.
     */
    void borrowBook(String securityToken, Book book);

    /**
     * Creating new user.
     * @param user that may be created.
     */
    void createUser(String securityToken, UserVO user) throws IllegalAccessException;

    /**
     * Creates new user session.
     * @return unique security token.
     */
    String loginUser(String login, String password) throws AuthenticationException;
}
