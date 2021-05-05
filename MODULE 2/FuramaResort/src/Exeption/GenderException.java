package Exeption;

public class GenderException extends Exception {
    public GenderException(){
        super("Gender is Female or male or unknow.");
    }
}
