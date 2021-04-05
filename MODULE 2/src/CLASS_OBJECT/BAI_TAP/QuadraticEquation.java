package CLASS_OBJECT.BAI_TAP;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double delTa() {
        return this.b * this.b - 4 * this.a * this.c;
    }

    public double getRoot1() {
        return (-this.b + Math.sqrt(delTa())) / (2 * this.a);
    }

    public double getRoot2() {
        return (-this.b - Math.sqrt(delTa())) / (2 * this.a);
    }
    public void getResult(){
        if (delTa()>0){
            System.out.println("nghiem x1 = "+getRoot1()+" ;nghiem x2 = "+ getRoot2());
        } else if (delTa()==0){
            System.out.println("ngiem x1 = x2 = "+getRoot2());
        }else if (delTa()<0){
            System.out.println("phuong trinh vo nghiem");
        }
    }
}





















































































