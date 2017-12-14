package javaclasses.library.impl.book.fields;

public class BookTitle {

    private String value;

    public BookTitle(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookTitle bookTitle = (BookTitle) o;

        return value != null ? value.equals(bookTitle.value) : bookTitle.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
