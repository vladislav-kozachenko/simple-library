package javaclasses.library.impl.author;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorDAO {

    private Map<Long, Author> repository;
    private long id = 0;

    public AuthorDAO(){
        repository = new HashMap<>();
    }

    public void createAuthor(Author author) {
        author.setId(id);
        repository.put(id, author);
        id++;
    }

    public List<Author> findAll() {
        return new ArrayList<>(repository.values());
    }

    public Author findById(long id) {
        return repository.get(id);
    }
}
