package INHERITANCE.thuc_hanh;

public class TextSquare {
    public static void main(String[] args) {
        Square sq1 = new Square(50);
        sq1.setWidth(100);
        sq1.setHight(100);
        System.out.println(sq1.getaArea());
        System.out.println(sq1.toString());
    }
}
