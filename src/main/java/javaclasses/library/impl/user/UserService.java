package javaclasses.library.impl.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

public class UserService {

    private final UserDAO userDAO;
    private final MessageDigest MD5;


    public UserService(UserDAO userDAO) throws NoSuchAlgorithmException {
        this.userDAO = userDAO;
        MD5 = MessageDigest.getInstance("MD5");
    }

    public void createUser(String securityToken, UserVO userVO) {

        checkArgument(isNullOrEmpty(securityToken));
        checkArgument(isNullOrEmpty(userVO.getUsername()));
        checkArgument(isNullOrEmpty(userVO.getPassword()));

        userDAO.newUser(new User(userVO.getUsername(), MD5.digest(userVO.getUsername().getBytes())));
    }
}
