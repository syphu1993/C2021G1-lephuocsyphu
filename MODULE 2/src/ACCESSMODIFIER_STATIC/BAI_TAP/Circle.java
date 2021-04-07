package ACCESSMODIFIER_STATIC.BAI_TAP;

public class Circle {
    private double radius = 5.0;
    private String collor = "red";
    public Circle() {
    }
    public Circle(double radius) {
        this.radius = radius;
    }
     protected double getRadius() {
        return radius;
    }
     public double getArea(){
        return 3.14*this.radius*this.radius;
     }
}
