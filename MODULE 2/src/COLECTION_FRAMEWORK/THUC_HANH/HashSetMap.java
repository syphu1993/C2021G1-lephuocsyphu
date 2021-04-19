package COLECTION_FRAMEWORK.THUC_HANH;

import STACK__QUEUE.BAI_TAP.Student;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashSetMap {
    public static void main(String[] args) {
        Student student1 = new Student("phu","nam",28);
        Student student2 = new Student("nam","nam",23);
        Student student3 = new Student("hien","nu",24);
        Map<Integer,Student> hashMap = new HashMap<>();
        hashMap.put(1,student1);
        hashMap.put(2,student2);
        hashMap.put(3,student3);
        hashMap.put(4,student1);
        for(Map.Entry<Integer, Student> student : hashMap.entrySet()) {
            System.out.println(student.toString());
        }
        Set<Student> set = new HashSet<>();
        set.add(student1);
        set.add(student2);
        set.add(student3);
        set.add(student1);
        for(Student student : set){
            System.out.println(student.toString());
        }
    }
}
