package javaclasses.library;

import javaclasses.library.impl.LibraryImpl;
import javaclasses.library.impl.author.Author;
import javaclasses.library.impl.author.AuthorVO;
import javaclasses.library.impl.book.BookVO;
import javaclasses.library.impl.user.User;
import javaclasses.library.impl.user.UserRole;
import javaclasses.library.impl.user.UserVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.AuthenticationException;

import static org.junit.Assert.*;


public class LibraryTest {

    private Library library;

    @Before
    public void setLibrary(){
        library = new LibraryImpl();
    }

    @Test
    public void testCreateUser() throws AuthenticationException, IllegalAccessException {
        UserVO user = new UserVO("User", "awesomename", UserRole.VISITOR);
        String token = library.loginUser("admin", "password");
        library.createUser(token, user);
        assertNotNull(library.loginUser("User", "awesomename"));
    }

    @Test
    public void testLoginAdmin() throws AuthenticationException {
        assertNotNull(library.loginUser("admin", "password"));
    }

    @Test
    public void testAddingAuthors() throws AuthenticationException, IllegalAccessException {
        String adminToken = library.loginUser("admin", "password");
        library.createUser(adminToken, new UserVO("librarian", "12345", UserRole.LIBRARIAN));
        String librarianToken = library.loginUser("librarian", "12345");
        library.addAuthor(librarianToken, new AuthorVO("John", "Tolkien"));
        Author author = library.getAuthors().get(0);
        assertEquals(author.getFirstName(), "John");
    }

    @Test
    public void testAuthorsGettingById() throws AuthenticationException, IllegalAccessException {
        String adminToken = library.loginUser("admin", "password");
        library.createUser(adminToken, new UserVO("librarian", "12345", UserRole.LIBRARIAN));
        String librarianToken = library.loginUser("librarian", "12345");
        library.addAuthor(librarianToken, new AuthorVO("John", "Tolkien"));
        Author author = library.getAuthorById(0);
        assertEquals(author.getFirstName(), "John");
    }

    @Test
    public void testBookAdding() throws AuthenticationException, IllegalAccessException {
        String adminToken = library.loginUser("admin", "password");
        library.createUser(adminToken, new UserVO("librarian", "12345", UserRole.LIBRARIAN));
        String librarianToken = library.loginUser("librarian", "12345");
        library.addAuthor(librarianToken, new AuthorVO("John", "Tolkien"));
        library.addBook(librarianToken, new BookVO("LOTR"), 0);
        assertEquals("LOTR", library.getBookById(librarianToken, 0).getName());
    }

    @Test
    public void testBookBorrowing() throws AuthenticationException, IllegalAccessException {
        String adminToken = library.loginUser("admin", "password");
        library.createUser(adminToken, new UserVO("librarian", "12345", UserRole.LIBRARIAN));
        String librarianToken = library.loginUser("librarian", "12345");
        library.addAuthor(librarianToken, new AuthorVO("John", "Tolkien"));
        library.addBook(librarianToken, new BookVO("LOTR"), 0);
        library.createUser(adminToken, new UserVO("visitor", "12345", UserRole.VISITOR));
        String visitorToken = library.loginUser("visitor", "12345");
        library.borrowBook(visitorToken, new BookVO(0));
        assertEquals("LOTR", library.getBorrowedBooks(visitorToken).get(0).getName());
    }
}
