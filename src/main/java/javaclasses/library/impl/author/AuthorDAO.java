package javaclasses.library.impl.author;

import java.util.Map;

public class AuthorDAO {

    private Map<Long, Author> repository;
    private long id = 0;

    public void createAuthor(Author author) {
        author.setId(id);
        repository.put(id, author);
        id++;
    }
}
