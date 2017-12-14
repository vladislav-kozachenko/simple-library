package javaclasses.library.impl.author;

import javaclasses.library.impl.author.fields.AuthorID;
import javaclasses.library.impl.author.fields.AuthorName;

public class Author {

    private AuthorName name;
    private AuthorID id;

    public Author(AuthorName name) {
        this.name = name;
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
}
