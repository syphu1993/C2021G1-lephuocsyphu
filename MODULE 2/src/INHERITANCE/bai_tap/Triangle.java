package INHERITANCE.bai_tap;

import INHERITANCE.thuc_hanh.Shape;

public class Triangle extends Shape {
    protected double side1;
    protected double side2;
    protected double side3;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(String collor, boolean filled, double side1, double side2, double side3) {
        super(collor, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
    protected double getChuVI(){
        return side1+side2+side3;
    }
    protected double getDienTich(){
        return Math.sqrt((getChuVI()/2)*(getChuVI()/2-side1)*(getChuVI()/2-side2)*(getChuVI()/2-side3));
    }

    @Override
    public String toString() {
        return "Triangle{ mau:"+getCollor()+", Dien tich :"+getDienTich()+", Chu vi :"+ getChuVI()+"}";
    }
}
