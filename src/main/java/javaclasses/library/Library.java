package javaclasses.library;

import javaclasses.library.impl.author.Author;
import javaclasses.library.impl.author.AuthorVO;
import javaclasses.library.impl.book.Book;
import javaclasses.library.impl.book.BookVO;
import javaclasses.library.impl.user.UserVO;

import javax.naming.AuthenticationException;
import java.util.List;

/**
 * Represents library management system.
 *
 * @author Kozachenko
 */
public interface Library {

    /**
     * Adds new book to book storage.
     *
     * @param book is the book may be added.
     */
    void addBook(String securityToken, BookVO book, long... authorIds) throws IllegalAccessException;

    Book getBookById(String securityToken, long id);

    /**
     * Assign book that may be borrowed to the user that needs to borrow it.
     *
     * @param securityToken unique security token may be used to get user and check if the user is logged in.
     * @param book          is the book that may be borrowed.
     */
    void borrowBook(String securityToken, BookVO book) throws IllegalAccessException;

    /**
     * Creating new user.
     *
     * @param user that may be created.
     */
    void createUser(String securityToken, UserVO user) throws IllegalAccessException;

    /**
     * Creates new user session.
     *
     * @return unique security token.
     */
    String loginUser(String login, String password) throws AuthenticationException;

    /**
     * Creates new user author.
     *
     * @param securityToken unique security token may be used to get user and check if the user is logged in
     *                      and have permissions to create author.
     * @param author        that may be created.
     */
    void addAuthor(String securityToken, AuthorVO author) throws IllegalAccessException;

    /**
     * Returns list of all author has been added to library.
     */
    List<Author> getAuthors();

    /**
     * Finds author with inputted id in library.
     * @param id for author searching.
     * @return author with needed id.
     */
    Author getAuthorById(long id);
}
