package javaclasses.library.impl.book;

import javaclasses.library.impl.author.Author;
import javaclasses.library.impl.book.fields.BookID;
import javaclasses.library.impl.book.fields.BookTitle;

import java.util.List;

public class Book {

    private BookID id;
    private BookTitle title;
    private List<Author> authors;

    public Book(BookTitle title, List<Author> authors) {
        this.title = title;
        this.authors = authors;
    }

    public void setId(BookID id) {
        this.id = id;
    }

    public BookTitle getTitle() {
        return title;
    }
}
