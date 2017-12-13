package javaclasses.library;

import javaclasses.library.impl.LibraryImpl;
import javaclasses.library.impl.user.User;
import javaclasses.library.impl.user.UserRole;
import javaclasses.library.impl.user.UserVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.AuthenticationException;


public class LibraryTest {

    private Library library;

    @Before
    public void setLibrary(){
        library = new LibraryImpl();
    }

    @Test
    public void testCreateUser(){
        UserVO user = new UserVO("User", "awesomename", UserRole.VISITOR);
    }

    @Test
    public void testLoginAdmin() throws AuthenticationException {
        Assert.assertNotNull(library.loginUser("admin", "password"));
    }
}
