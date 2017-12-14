package javaclasses.library.impl.book;

import javaclasses.library.NoPermissionException;
import javaclasses.library.impl.author.Author;
import javaclasses.library.impl.author.AuthorService;
import javaclasses.library.impl.author.AuthorServiceImpl;
import javaclasses.library.impl.author.AuthorVO;
import javaclasses.library.impl.user.UserPermission;
import javaclasses.library.impl.user.UserService;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private final BookDAO bookDAO;
    private final UserService userService;
    private final AuthorService authorService;

    public BookService(BookDAO bookDAO, UserService userService, AuthorService authorService) {
        this.bookDAO = bookDAO;
        this.userService = userService;
        this.authorService = authorService;
    }

    public void createBook(String securityToken, BookVO bookVO, AuthorVO... authorVOs) throws NoPermissionException {
        userService.checkUserPermission(securityToken, UserPermission.CREATE_BOOK);
        List<Author> authors = new ArrayList<>();
        for (AuthorVO authorVO : authorVOs) {
            authors.add(authorService.getById(authorVO.getId()));
        }
        final Book book = new Book(bookVO.getName(), authors);
        bookDAO.create(book);
        for (Author author : authors) {
            author.addBook(book);
        }
    }

    public Book getBookById(long id) {
        return bookDAO.findById(id);
    }

    public void borrowBook(String securityToken, BookVO bookVO) throws NoPermissionException {
        userService.checkUserPermission(securityToken, UserPermission.BORROW_BOOK);
        final Book book = getBookById(bookVO.getId());
        userService.borrowBook(securityToken, book);
    }
}
