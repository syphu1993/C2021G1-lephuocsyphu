package STACK__QUEUE.BAI_TAP;

import java.util.*;

public class FilterStudent {
    public static void main(String[] args) {
        Student student1 = new Student("phu","nam",1993);
        Student student2 = new Student("nam","nam",1990);
        Student student3 = new Student("lan","nu",1991);
        Student student4 = new Student("hong","nu",1995);
        Student student5 = new Student("phong","nam",1996);
        Student student6 = new Student("hue","nu",1999);
        ArrayList<Student> listStudent = new ArrayList<>();
        listStudent.add(student1);
        listStudent.add(student2);
        listStudent.add(student3);
        listStudent.add(student4);
        listStudent.add(student5);
        listStudent.add(student6);
        Queue<Student> queueNu = new LinkedList<>();
        Queue<Student> queueNam = new LinkedList<>();
//        listStudent.sort(new Comparator<Student>(){
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getYear()-o2.getYear();
//            }
//        });
        Comparator studentComparator = new Student();
        Collections.sort(listStudent,studentComparator);
        System.out.println(listStudent);
        Collections.reverse(listStudent);
//        listStudent.sort(studentComparator);
        System.out.println(listStudent);
        for (Student student:listStudent) {
            if (student.getGenger().equals("nam")){
                queueNam.add(student);
            } else {
                queueNu.add(student);
            }
        }
        System.out.println(queueNam);
        System.out.println(queueNu);
    }
}
