package javaclasses.library;

import javaclasses.library.impl.LibraryImpl;
import javaclasses.library.impl.author.Author;
import javaclasses.library.impl.author.AuthorVO;
import javaclasses.library.impl.author.fields.AuthorID;
import javaclasses.library.impl.author.fields.AuthorName;
import javaclasses.library.impl.book.fields.BookID;
import javaclasses.library.impl.book.fields.BookTitle;
import javaclasses.library.impl.book.BookVO;
import javaclasses.library.impl.user.UserName;
import javaclasses.library.impl.user.UserVO;
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
        adminToken = library.loginUser(new UserName("admin"), "password");
    }

    @Test
    public void testCreateUser() throws LoginFailException, NoPermissionException {
        UserVO user = new UserVO(new UserName("User"), "password", VISITOR);
        library.createUser(adminToken, user);
        assertNotNull(library.loginUser(new UserName("User"), "password"));
    }

    @Test
    public void testLoginAdmin() throws LoginFailException {
        assertNotNull(library.loginUser(new UserName("admin"), "password"));
    }

    @Test
    public void testAddingAuthors() throws LoginFailException, NoPermissionException {
        createAndLoginLibrarian();
        library.addAuthor(librarianToken, new AuthorVO(new AuthorName("John Tolkien")));
        Author author = library.getAuthors().get(0);
        assertEquals(author.getName().getValue(), "John Tolkien");
    }

    @Test
    public void testAuthorsGettingById() throws LoginFailException, NoPermissionException {
        createAndLoginLibrarian();
        library.addAuthor(librarianToken, new AuthorVO(new AuthorName("John Tolkien")));
        Author author = library.getAuthorById(new AuthorID(0));
        assertEquals(author.getName().getValue(), "John Tolkien");
    }

    @Test
    public void testBookAdding() throws LoginFailException, NoPermissionException {
        createAndLoginLibrarian();
        library.addAuthor(librarianToken, new AuthorVO(new AuthorName("John Tolkien")));
        library.addBook(librarianToken, new BookVO(new BookTitle("LOTR")), new AuthorVO(new AuthorID(0)));
        assertEquals("LOTR", library.getBookById(librarianToken, new BookID(0)).getTitle().getValue());
    }

    @Test
    public void testBookBorrowing() throws LoginFailException, NoPermissionException {
        createAndLoginLibrarian();
        library.addAuthor(librarianToken, new AuthorVO(new AuthorName("John Tolkien")));
        library.addBook(librarianToken, new BookVO(new BookTitle("LOTR")), new AuthorVO(new AuthorID(0)));
        createAndLoginVisitor();
        library.borrowBook(visitorToken, new BookVO(new BookID(0)));
        assertEquals("LOTR", library.getBorrowedBooks(visitorToken).get(0).getTitle().getValue());
    }

    private void createAndLoginVisitor() throws NoPermissionException, LoginFailException {
        library.createUser(adminToken, new UserVO(new UserName("visitor"), "12345", VISITOR));
        visitorToken = library.loginUser(new UserName("visitor"), "12345");
    }

    private void createAndLoginLibrarian() throws NoPermissionException, LoginFailException {
        library.createUser(adminToken, new UserVO(new UserName("librarian"), "12345", LIBRARIAN));
        librarianToken = library.loginUser(new UserName("librarian"), "12345");
    }
}
