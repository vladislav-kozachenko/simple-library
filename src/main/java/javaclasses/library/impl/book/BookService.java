package javaclasses.library.impl.book;

import javaclasses.library.impl.author.Author;
import javaclasses.library.impl.author.AuthorService;
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

    public void createBook(String securityToken, BookVO bookVO, long... authorIds) throws IllegalAccessException {
        userService.checkUserPermission(securityToken, UserPermission.CREATE_BOOK);
        List<Author> authors = new ArrayList<>();
        for (long authorId : authorIds) {
            authors.add(authorService.getById(authorId));
        }
        bookDAO.create(new Book(bookVO.getName(), authors));
    }

    public Book getBookById(long id) {
        return bookDAO.findById(id);
    }
}
