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

public interface UserService {

    public void createUser(String securityToken, UserVO userVO) throws NoPermissionException;

    public void checkUserPermission(String securityToken, UserPermission permission) throws NoPermissionException;

    public String loginUser(UserName login, String password) throws LoginFailException;

    public void borrowBook(String securityToken, Book book) throws NoPermissionException;

    public List<Book> getBorrowedBooks(String securityToken) throws NoPermissionException;
}
