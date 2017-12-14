package javaclasses.library.impl.book;

import javaclasses.library.NoPermissionException;
import javaclasses.library.impl.author.Author;
import javaclasses.library.impl.author.AuthorService;
import javaclasses.library.impl.author.AuthorVO;
import javaclasses.library.impl.book.fields.BookID;
import javaclasses.library.impl.user.UserPermission;
import javaclasses.library.impl.user.UserService;

import java.util.ArrayList;
import java.util.List;

public interface BookService {

    void createBook(String securityToken, BookVO bookVO, AuthorVO... authorVOs) throws NoPermissionException;

    Book getBookById(BookID id);

    void borrowBook(String securityToken, BookVO bookVO) throws NoPermissionException;
}
