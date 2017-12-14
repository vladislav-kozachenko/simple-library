package javaclasses.library.impl.book;

public class BookVO {

    private long id;
    private String name;

    public BookVO(long id) {
        this.id = id;
    }

    public BookVO(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
