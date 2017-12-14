package javaclasses.library.impl.author;

import javaclasses.library.NoPermissionException;
import javaclasses.library.impl.author.fields.AuthorID;

import java.util.List;

public interface AuthorService {

    void createAuthor(String securityToken, AuthorVO authorVO) throws NoPermissionException;

    List<Author> getAllAuthors();

    Author getById(AuthorID id);

}
