package javaclasses.library.impl.author;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javaclasses.library.impl.user.UserPermission;
import javaclasses.library.impl.user.UserService;

public class AuthorService {

    private final AuthorDAO authorDAO;
    private final UserService userService;

    public AuthorService(AuthorDAO authorDAO, UserService userService) {
        this.authorDAO = authorDAO;
        this.userService = userService;
    }

    public void createAuthor(String securityToken, AuthorVO authorVO) throws IllegalAccessException {
        Preconditions.checkNotNull(authorVO);
        userService.checkUserPermission(securityToken, UserPermission.CREATE_AUTHOR);
        Author author = new Author(authorVO.getFirstName(), authorVO.getLastName());
        authorDAO.createAuthor(author);
    }
}
