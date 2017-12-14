package javaclasses.library.impl.book.fields;

public class BookID {

    private long value;

    public BookID(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookID bookID = (BookID) o;

        return value == bookID.value;
    }

    @Override
    public int hashCode() {
        return (int) (value ^ (value >>> 32));
    }
}
