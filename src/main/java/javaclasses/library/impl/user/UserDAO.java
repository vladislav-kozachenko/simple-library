package javaclasses.library.impl.user;

public class UserDAO {

    private final UserRepository userRepository;

    public UserDAO() {
        this.userRepository = new UserRepository();
    }

}
