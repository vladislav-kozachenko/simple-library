package javaclasses.library.impl.book;

import javaclasses.library.NoPermissionException;
import javaclasses.library.impl.author.AuthorVO;
import javaclasses.library.impl.book.fields.BookID;

public interface BookService {

    void createBook(String securityToken, BookVO bookVO, AuthorVO... authorVOs) throws NoPermissionException;

    Book getBookById(BookID id);

    void borrowBook(String securityToken, BookVO bookVO) throws NoPermissionException;
}
