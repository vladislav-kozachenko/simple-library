package javaclasses.library.impl.user;

import javaclasses.library.impl.book.Book;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {

    private long identifier = 0;
    private Map<Long, User> repository;

    public UserDAO() {
        repository = new HashMap<>();
    }

    public void newUser(User user){
        repository.put(identifier, user);
        user.setId(new UserID(identifier));
        identifier++;
    }


    public User findByUsername(UserName login) {
        for (User user : repository.values()) {
            if (user.getUsername().equals(login)){
                return user;
            }
        }
        return null;
    }

    public void borrowBook(User user, Book book) {
        repository.get(user.getId().getValue()).getBorrowedBooks().add(book);
    }
}
