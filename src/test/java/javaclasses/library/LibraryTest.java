package javaclasses.library;

import javaclasses.library.impl.LibraryImpl;
import javaclasses.library.impl.user.User;
import javaclasses.library.impl.user.UserVO;
import org.junit.Before;
import org.junit.Test;

public class LibraryTest {

    private Library library;

    @Before
    public void setLibrary(){
        library = new LibraryImpl();
    }

    @Test
    public void testCreateUser(){
        UserVO user = new UserVO("User", "awesomename");

    }
}
