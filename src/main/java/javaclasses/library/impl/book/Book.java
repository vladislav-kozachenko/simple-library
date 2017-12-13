package javaclasses.library.impl.book;

import javaclasses.library.impl.author.Author;

import java.util.List;

public class Book {

    private long id;
    private String name;
    private List<Author> authors;

    public Book(String name, List<Author> authors) {
        this.name = name;
        this.authors = authors;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
