package COLECTION_FRAMEWORK.THUC_HANH;
import java.util.ArrayList;
import java.util.Collections;

public class MainStudent {
    public static void main(String[] args) {
        Student student1 = new Student("phu","nam",1993);
        Student student2 = new Student("nam","nam",1990);
        Student student3 = new Student("lan","nu",1991);
        Student student4 = new Student("hong","nu",1995);
        Student student5 = new Student("phong","nam",1996);
        Student student6 = new Student("hue","nu",1999);
        ArrayList<Student> listStudent2 = new ArrayList<>();
        listStudent2.add(student1);
        listStudent2.add(student2);
        listStudent2.add(student3);
        listStudent2.add(student4);
        listStudent2.add(student5);
        listStudent2.add(student6);
        System.out.println(listStudent2);
        ToanSapXep sapXep = new ToanSapXep();
        Collections.sort(listStudent2);
        System.out.println(listStudent2);
        Collections.sort(listStudent2,sapXep);
        System.out.println(listStudent2);
    }
}
