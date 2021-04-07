package INHERITANCE.thuc_hanh;

public class Circle extends Shape {
    private double radius=1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String collor, boolean filled, double radius) {
        super(collor, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    protected double getArea(){
        return radius*radius*3.14;
    }
    protected double getPerimeter(){
        return 2*radius*3.14;
    }
    @Override
    public String toString() {
        return "Circle with radius "+ getRadius() + " which is subclass of " + super.toString();
    }
}
