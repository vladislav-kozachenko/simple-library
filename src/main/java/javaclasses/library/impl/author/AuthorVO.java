package javaclasses.library.impl.author;

public class AuthorVO {

    private String firstName;
    private String lastName;

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


}
