package javaclasses.library.impl;

import javaclasses.library.Library;
import javaclasses.library.LoginFailException;
import javaclasses.library.NoPermissionException;
import javaclasses.library.impl.UserSession.UserSessionDAO;
import javaclasses.library.impl.UserSession.UserSessionService;
import javaclasses.library.impl.author.Author;
import javaclasses.library.impl.author.AuthorDAO;
import javaclasses.library.impl.author.AuthorService;
import javaclasses.library.impl.author.AuthorVO;
import javaclasses.library.impl.author.fields.AuthorID;
import javaclasses.library.impl.book.Book;
import javaclasses.library.impl.book.BookDAO;
import javaclasses.library.impl.book.BookService;
import javaclasses.library.impl.book.BookVO;
import javaclasses.library.impl.user.UserDAO;
import javaclasses.library.impl.user.UserService;
import javaclasses.library.impl.user.UserVO;

import java.util.List;


/**
 * Represents implementation of library management system.
 */
public class LibraryImpl implements Library {

    private final UserService userService;
    private final AuthorService authorService;
    private final UserSessionService userSessionService;
    private final BookService bookService;

    public LibraryImpl()  {
        UserSessionDAO userSessionDAO = new UserSessionDAO();
        userSessionService = new UserSessionService(userSessionDAO);
        final UserDAO userDAO = new UserDAO();
        userService = new UserService(userDAO, userSessionService);
        final AuthorDAO authorDAO = new AuthorDAO();
        authorService = new AuthorService(authorDAO, userService);
        final BookDAO bookDAO = new BookDAO();
        bookService = new BookService(bookDAO, userService, authorService);
    }

    @Override
    public List<Author> getAuthors() {
        return authorService.getAllAuthors();
    }

    @Override
    public void addBook(String securityToken, BookVO book, AuthorVO... authors) throws NoPermissionException {
        bookService.createBook(securityToken, book, authors);
    }

    @Override
    public Book getBookById(String securityToken, long id) {
        return bookService.getBookById(id);
    }

    @Override
    public void borrowBook(String securityToken, BookVO book) throws NoPermissionException {
        bookService.borrowBook(securityToken, book);
    }

    @Override
    public List<Book> getBorrowedBooks(String securityToken) throws NoPermissionException {
        return userService.getBorrowedBooks(securityToken);
    }

    @Override
    public void createUser(String securityToken, UserVO user) throws NoPermissionException {
        userService.createUser(securityToken, user);
    }

    @Override
    public String loginUser(String login, String password) throws LoginFailException {
        return userService.loginUser(login, password);
    }

    @Override
    public void addAuthor(String securityToken, AuthorVO author) throws NoPermissionException {
        authorService.createAuthor(securityToken, author);
    }

    @Override
    public Author getAuthorById(AuthorID id) {
        return authorService.getById(id);
    }
}
