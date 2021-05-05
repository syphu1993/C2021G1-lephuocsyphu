package Exeption;

public class BirthdayException extends Exception {
    public BirthdayException(){
        super("Birthday is not suitable. Input again,please!");
    }
}
