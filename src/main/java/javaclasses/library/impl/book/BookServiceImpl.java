package javaclasses.library.impl.book;

import javaclasses.library.NoPermissionException;
import javaclasses.library.impl.author.Author;
import javaclasses.library.impl.author.AuthorService;
import javaclasses.library.impl.author.AuthorVO;
import javaclasses.library.impl.book.fields.BookID;
import javaclasses.library.impl.user.UserPermission;
import javaclasses.library.impl.user.UserService;
import javaclasses.library.impl.user.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;
    private final UserService userService;
    private final AuthorService authorService;

    public BookServiceImpl(BookDAO bookDAO, UserService userService, AuthorService authorService) {
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
        final Book book = new Book(bookVO.getTitle(), authors);
        bookDAO.create(book);
        for (Author author : authors) {
            author.addBook(book);
        }
    }

    public Book getBookById(BookID id) {
        return bookDAO.findById(id.getValue());
    }

    public void borrowBook(String securityToken, BookVO bookVO) throws NoPermissionException {
        userService.checkUserPermission(securityToken, UserPermission.BORROW_BOOK);
        final Book book = getBookById(bookVO.getId());
        userService.borrowBook(securityToken, book);
    }
}
