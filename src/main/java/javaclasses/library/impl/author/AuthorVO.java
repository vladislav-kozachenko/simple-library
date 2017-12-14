package javaclasses.library.impl.author;

public class AuthorVO {

    private String firstName;
    private String lastName;
    private long id;

    public AuthorVO(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public AuthorVO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public long getId() {
        return id;
    }
}
