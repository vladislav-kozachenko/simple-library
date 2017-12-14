package javaclasses.library.impl.author;

import com.google.common.base.Preconditions;
import javaclasses.library.NoPermissionException;
import javaclasses.library.impl.author.fields.AuthorID;
import javaclasses.library.impl.author.fields.AuthorName;
import javaclasses.library.impl.user.UserPermission;
import javaclasses.library.impl.user.UserService;

import java.util.List;

public class AuthorService {

    private final AuthorDAO authorDAO;
    private final UserService userService;

    public AuthorService(AuthorDAO authorDAO, UserService userService) {
        this.authorDAO = authorDAO;
        this.userService = userService;
    }

    public void createAuthor(String securityToken, AuthorVO authorVO) throws NoPermissionException {
        Preconditions.checkNotNull(authorVO);
        userService.checkUserPermission(securityToken, UserPermission.CREATE_AUTHOR);
        Author author = new Author(authorVO.getName());
        authorDAO.createAuthor(author);
    }

    public List<Author> getAllAuthors() {
        return authorDAO.findAll();
    }

    public Author getById(AuthorID id) {
        return authorDAO.findById(id.getId());
    }
}
