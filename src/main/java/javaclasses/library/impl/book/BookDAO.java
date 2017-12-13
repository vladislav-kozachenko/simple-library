package javaclasses.library.impl.book;

import java.util.HashMap;
import java.util.Map;

public class BookDAO {

    private Map<Long, Book> repository;
    private long id;

    public BookDAO() {
        this.repository = new HashMap<>();
    }

    public void create(Book book) {
        book.setId(id);
        repository.put(id, book);
        id++;
    }
}
