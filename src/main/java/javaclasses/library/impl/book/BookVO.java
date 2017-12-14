package javaclasses.library.impl.book;

import javaclasses.library.impl.book.fields.BookID;
import javaclasses.library.impl.book.fields.BookTitle;

public class BookVO {

    private BookID id;
    private BookTitle title;

    public BookVO(BookTitle title) {
        this.title = title;
    }

    public BookVO(BookID id) {
        this.id = id;
    }

    public void setId(BookID id) {
        this.id = id;
    }

    public BookTitle getTitle() {
        return title;
    }

    public BookID getId() {
        return id;
    }
}
