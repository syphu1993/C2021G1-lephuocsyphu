package ACCESSMODIFIER_STATIC.THUC_HANH.com.godegym;

public class CreateCar {
    public static void main(String[] args) {
        Car car1 = new Car("toyota","aaa");
        System.out.println(Car.countCar);
        Car car2 = new Car("toyota2","aaacc");
        System.out.println(Car.countCar);
        Car car3 = new Car("toyota3","aaabb");
        System.out.println(Car.countCar);
    }
}
