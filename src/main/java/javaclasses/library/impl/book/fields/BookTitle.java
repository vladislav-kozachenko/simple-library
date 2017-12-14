package javaclasses.library.impl.book.fields;

public class BookTitle {

    private String name;

    public BookTitle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookTitle bookTitle = (BookTitle) o;

        return name != null ? name.equals(bookTitle.name) : bookTitle.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
