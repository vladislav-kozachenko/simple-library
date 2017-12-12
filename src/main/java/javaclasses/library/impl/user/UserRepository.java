package javaclasses.library.impl.user;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private long identifier = 0;

    private Map<Long, User> repository;

    public UserRepository(){
        repository = new HashMap<>();
    }

    public Map<Long, User> getRepository() {
        return repository;
    }

    public void insert(User user){
        repository.put(identifier, user);
        user.setId(identifier);
        identifier++;
    }

    public User read(long id){
        return repository.get(id);
    }
}
