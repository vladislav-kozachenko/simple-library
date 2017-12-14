package javaclasses.library.impl.UserSession;

import javaclasses.library.NoPermissionException;
import javaclasses.library.impl.user.User;

public class UserSessionDAO {

    private final UserSessionRepository repository;

    public UserSessionDAO(){
        repository = new UserSessionRepository();
    }

    public void createSession(UserSession session) {
        repository.insert(session);
    }

    public User getUserByToken(String securityToken) throws NoPermissionException {
        for (UserSession session : repository.getRepository().values()) {
            if (session.getToken().equals(securityToken)) {
                return session.getUser();
            }
        }
        throw new NoPermissionException("Cannot authenticate user with token.");
    }
}
