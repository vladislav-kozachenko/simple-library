package javaclasses.library;

import javaclasses.library.impl.LibraryImpl;
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
}
