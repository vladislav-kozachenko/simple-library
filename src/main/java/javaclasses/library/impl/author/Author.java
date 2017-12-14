package javaclasses.library.impl.author;

import javaclasses.library.impl.author.fields.AuthorID;
import javaclasses.library.impl.author.fields.AuthorName;
import javaclasses.library.impl.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Author {

    private AuthorName name;
    private AuthorID id;
    private List<Book> books;

    public Author(AuthorName name) {
        this.name = name;
        books = new ArrayList<>();
    }

    public AuthorName getName() {
        return name;
    }

    public void setName(AuthorName name) {
        this.name = name;
    }

    public AuthorID getId() {
        return id;
    }

    public void setId(AuthorID id) {
        this.id = id;
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
