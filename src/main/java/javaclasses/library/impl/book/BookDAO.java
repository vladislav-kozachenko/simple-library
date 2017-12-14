package javaclasses.library.impl.book;

import javaclasses.library.impl.book.fields.BookID;

import java.util.HashMap;
import java.util.Map;

public class BookDAO {

    private Map<Long, Book> repository;
    private long id;

    public BookDAO() {
        this.repository = new HashMap<>();
    }

    public void create(Book book) {
        book.setId(new BookID(id));
        repository.put(id, book);
        id++;
    }

    public Book findById(long id) {
        return repository.get(id);
    }
}
