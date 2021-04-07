package ACCESSMODIFIER_STATIC.THUC_HANH.com.godegym;

public class TestStatic {
    public static void main(String[] args) {
        Student student1 = new Student(1,"phu");
        Student student2 = new Student(2,"nam");
        Student student3 = new Student(3,"hung");
        student1.change("DHSP");
        student1.disPlay();
        student2.disPlay();
        student3.disPlay();
    }
}
