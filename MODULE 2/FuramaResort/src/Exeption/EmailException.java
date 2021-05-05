package Exeption;

public class EmailException extends Exception {
    public EmailException(){
        super("Email has at least 1 point and only character @.");
    }
}
