package javaclasses.library.impl.user;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private Map<Long, User> repository;

    public UserRepository(){
        repository = new HashMap<>();
    }

    public Map<Long, User> getRepository() {
        return repository;
    }
}
