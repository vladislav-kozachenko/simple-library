package javaclasses.library.impl.user;

import javaclasses.library.LoginFailException;
import javaclasses.library.NoPermissionException;
import javaclasses.library.impl.UserSession.UserSessionService;
import javaclasses.library.impl.book.Book;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;
import static javaclasses.library.impl.user.UserPermission.BORROW_BOOK;
import static javaclasses.library.impl.user.UserPermission.CREATE_USER;
import static javaclasses.library.impl.user.UserRole.ADMIN;

public class UserService {

    private final UserDAO userDAO;
    private final UserSessionService userSessionService;
    private MessageDigest MD5;


    public UserService(UserDAO userDAO, UserSessionService userSessionService)  {
        this.userDAO = userDAO;
        this.userSessionService = userSessionService;
        try {
            MD5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        createAdmin();
    }

    public void createUser(String securityToken, UserVO userVO) throws NoPermissionException {

        checkArgument(!isNullOrEmpty(securityToken));
        checkUserPermission(securityToken, CREATE_USER);
        checkArgument(!isNullOrEmpty(userVO.getUsername().getValue()));
        checkArgument(!isNullOrEmpty(userVO.getPassword()));

        userDAO.newUser(new User(userVO.getUsername(), MD5.digest(userVO.getPassword().getBytes()), userVO.getRole()));
    }

    public void checkUserPermission(String securityToken, UserPermission permission) throws NoPermissionException {
        final User user = userSessionService.getUserBySecurityToken(securityToken);
        if (!Arrays.asList(user.getRole().getPermissions()).contains(permission)){
            throw new NoPermissionException("User needs permission " + permission.name());
        }
    }

    public String loginUser(UserName login, String password) throws LoginFailException {
        checkArgument(!isNullOrEmpty(login.getValue()));
        checkArgument(!isNullOrEmpty(password));

        User user = userDAO.findByUsername(login);
        checkNotNull(user);

        if (Arrays.equals(MD5.digest(password.getBytes()), (user.getPassword()))){
            return userSessionService.createSession(user);
        }

        throw new LoginFailException("Invalid username or password.");
    }

    private void createAdmin(){
        userDAO.newUser(new User(new UserName("admin"), MD5.digest("password".getBytes()), ADMIN));
    }

    public void borrowBook(String securityToken, Book book) throws NoPermissionException {
        checkNotNull(book);
        User user = userSessionService.getUserBySecurityToken(securityToken);
        userDAO.borrowBook(user, book);
    }

    public List<Book> getBorrowedBooks(String securityToken) throws NoPermissionException {
        checkArgument(!isNullOrEmpty(securityToken));
        checkUserPermission(securityToken, BORROW_BOOK);
        return userSessionService.getUserBySecurityToken(securityToken).getBorrowedBooks();
    }
}
