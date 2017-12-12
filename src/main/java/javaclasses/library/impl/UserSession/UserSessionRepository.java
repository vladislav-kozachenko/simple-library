package javaclasses.library.impl.UserSession;

import java.util.HashMap;
import java.util.Map;

public class UserSessionRepository {

    private long id;

    private final Map<Long, UserSession> repository;

    public UserSessionRepository(){
        repository = new HashMap<>();
    }

    public void insert(UserSession session) {
        repository.put(id, session);
        session.setId(id);
        id++;
    }
}
