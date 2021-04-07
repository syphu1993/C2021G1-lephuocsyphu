package ACCESSMODIFIER_STATIC.THUC_HANH.com.godegym;

public class Student {
    private int id;
    private String name;
    private static String college = "DHBK";

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    static String change( String string){
        return college = string;
    }
    void disPlay(){
        System.out.println("ID : " + id + " ,name : " + name + " ,college :" + college);
    }
}
