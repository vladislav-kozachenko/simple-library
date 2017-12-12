package javaclasses.library.impl.UserSession;

public class UserSessionDAO {

    private final UserSessionRepository repository;

    public UserSessionDAO(){
        repository = new UserSessionRepository();
    }

    public void createSession(UserSession session) {
        repository.insert(session);
    }
}
