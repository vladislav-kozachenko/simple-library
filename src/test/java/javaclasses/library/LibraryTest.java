package javaclasses.library;

import javaclasses.library.impl.LibraryImpl;
import javaclasses.library.impl.author.Author;
import javaclasses.library.impl.author.AuthorVO;
import javaclasses.library.impl.author.fields.AuthorID;
import javaclasses.library.impl.author.fields.AuthorName;
import javaclasses.library.impl.book.BookVO;
import javaclasses.library.impl.user.User;
import javaclasses.library.impl.user.UserRole;
import javaclasses.library.impl.user.UserVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static javaclasses.library.impl.user.UserRole.*;
import static org.junit.Assert.*;


public class LibraryTest {

    private Library library;
    private String adminToken;
    private String librarianToken;
    private String visitorToken;

    @Before
    public void setLibrary() throws LoginFailException {
        library = new LibraryImpl();
        adminToken = library.loginUser("admin", "password");
    }

    @Test
    public void testCreateUser() throws LoginFailException, NoPermissionException {
        UserVO user = new UserVO("User", "password", VISITOR);
        library.createUser(adminToken, user);
        assertNotNull(library.loginUser("User", "password"));
    }

    @Test
    public void testLoginAdmin() throws LoginFailException {
        assertNotNull(library.loginUser("admin", "password"));
    }

    @Test
    public void testAddingAuthors() throws LoginFailException, NoPermissionException {
        createAndLoginLibrarian();
        library.addAuthor(librarianToken, new AuthorVO(new AuthorName("John Tolkien")));
        Author author = library.getAuthors().get(0);
        assertEquals(author.getName().getName(), "John Tolkien");
    }

    @Test
    public void testAuthorsGettingById() throws LoginFailException, NoPermissionException {
        createAndLoginLibrarian();
        library.addAuthor(librarianToken, new AuthorVO(new AuthorName("John Tolkien")));
        Author author = library.getAuthorById(new AuthorID(0));
        assertEquals(author.getName().getName(), "John Tolkien");
    }

    @Test
    public void testBookAdding() throws LoginFailException, NoPermissionException {
        createAndLoginLibrarian();
        library.addAuthor(librarianToken, new AuthorVO(new AuthorName("John Tolkien")));
        library.addBook(librarianToken, new BookVO("LOTR"), new AuthorVO(new AuthorID(0)));
        assertEquals("LOTR", library.getBookById(librarianToken, 0).getName());
    }

    @Test
    public void testBookBorrowing() throws LoginFailException, NoPermissionException {
        createAndLoginLibrarian();
        library.addAuthor(librarianToken, new AuthorVO(new AuthorName("John Tolkien")));
        library.addBook(librarianToken, new BookVO("LOTR"), new AuthorVO(new AuthorID(0)));
        createAndLoginVisitor();
        library.borrowBook(visitorToken, new BookVO(0));
        assertEquals("LOTR", library.getBorrowedBooks(visitorToken).get(0).getName());
    }

    private void createAndLoginVisitor() throws NoPermissionException, LoginFailException {
        library.createUser(adminToken, new UserVO("visitor", "12345", VISITOR));
        visitorToken = library.loginUser("visitor", "12345");
    }

    private void createAndLoginLibrarian() throws NoPermissionException, LoginFailException {
        library.createUser(adminToken, new UserVO("librarian", "12345", LIBRARIAN));
        librarianToken = library.loginUser("librarian", "12345");
    }
}
