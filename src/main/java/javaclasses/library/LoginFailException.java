package javaclasses.library;

public class LoginFailException extends Exception {
    public LoginFailException(String errorMessage) {
        super(errorMessage);
    }
}
