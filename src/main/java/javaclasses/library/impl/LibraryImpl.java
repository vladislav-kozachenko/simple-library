package javaclasses.library.impl;

import javaclasses.library.Library;
import javaclasses.library.impl.UserSession.UserSessionDAO;
import javaclasses.library.impl.UserSession.UserSessionService;
import javaclasses.library.impl.author.Author;
import javaclasses.library.impl.author.AuthorDAO;
import javaclasses.library.impl.author.AuthorService;
import javaclasses.library.impl.author.AuthorVO;
import javaclasses.library.impl.book.Book;
import javaclasses.library.impl.book.BookDAO;
import javaclasses.library.impl.book.BookService;
import javaclasses.library.impl.book.BookVO;
import javaclasses.library.impl.user.UserDAO;
import javaclasses.library.impl.user.UserService;
import javaclasses.library.impl.user.UserVO;

import javax.naming.AuthenticationException;
import java.util.List;


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
    private final BookService bookService;
    private final BookDAO bookDAO;

    public LibraryImpl()  {
        userSessionDAO = new UserSessionDAO();
        userSessionService = new UserSessionService(userSessionDAO);
        userDAO = new UserDAO();
        userService = new UserService(userDAO, userSessionService);
        authorDAO = new AuthorDAO();
        authorService = new AuthorService(authorDAO, userService);
        bookDAO = new BookDAO();
        bookService = new BookService(bookDAO, userService, authorService);
    }

    @Override
    public List<Author> getAuthors() {
        return authorService.getAllAuthors();
    }

    @Override
    public void addBook(String securityToken, BookVO book, AuthorVO... authors) throws IllegalAccessException {
        bookService.createBook(securityToken, book, authors);
    }

    @Override
    public Book getBookById(String securityToken, long id) {
        return bookService.getBookById(id);
    }

    @Override
    public void borrowBook(String securityToken, BookVO book) throws IllegalAccessException {
        bookService.borrowBook(securityToken, book);
    }

    @Override
    public List<Book> getBorrowedBooks(String securityToken) throws IllegalAccessException {
        return userService.getBorrowedBooks(securityToken);
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

    @Override
    public Author getAuthorById(long id) {
        return authorService.getById(id);
    }
}
