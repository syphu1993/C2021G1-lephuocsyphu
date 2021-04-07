package INHERITANCE.bai_tap;

public class Circle {
    protected String collor;
    protected double radius;

    public Circle() {
    }

    public Circle(String collor, double radius) {
        this.collor = collor;
        this.radius = radius;
    }

    public String getCollor() {
        return collor;
    }

    public void setCollor(String collor) {
        this.collor = collor;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    protected double getArea(){
        return this.radius*this.radius*Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "collor='" + collor + '\'' +
                ", radius=" + radius +
                '}';
    }
}
