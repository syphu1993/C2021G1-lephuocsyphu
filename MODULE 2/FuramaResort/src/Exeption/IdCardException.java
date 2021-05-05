package Exeption;

public class IdCardException extends Exception {
    public IdCardException(){
        super("Id contain 9 numbers.");
    }
}
