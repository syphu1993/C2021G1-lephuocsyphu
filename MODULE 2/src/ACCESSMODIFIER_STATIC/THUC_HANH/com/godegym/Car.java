package ACCESSMODIFIER_STATIC.THUC_HANH.com.godegym;

public class Car {
    private String name;
    private String enige;
    public static int countCar;

    public Car(String name, String enige) {
        this.name = name;
        this.enige = enige;
        countCar++;
    }
}
