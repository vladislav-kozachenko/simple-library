package javaclasses.library.impl.author;

import javaclasses.library.impl.author.fields.AuthorID;
import javaclasses.library.impl.author.fields.AuthorName;

public class AuthorVO {

    private AuthorName name;
    private AuthorID id;

    public AuthorVO(AuthorName name) {
        this.name = name;
    }

    public AuthorVO(AuthorID id) {
        this.id = id;
    }

    public AuthorName getName() {
        return name;
    }

    public AuthorID getId() {
        return id;
    }

    public void setId(AuthorID id) {
        this.id = id;
    }
}
