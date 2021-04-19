package COLECTION_FRAMEWORK.THUC_HANH;

import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> student = new HashMap<>();
        student.put("John", 30);
        student.put("Mike", 28);
        student.put("Bill", 32);
        student.put("Maria", 27);
        student.put("Toni", 27);
        System.out.println("Display entries of hashmap: ");
        System.out.println(student);
        Map<String,Integer> treeMap = new TreeMap<>(student);
        System.out.println("Display treemap: ");
        System.out.println(treeMap);
        Map<String,Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("John", 30);
        linkedHashMap.put("Mike", 28);
        linkedHashMap.put("Bill", 32);
        linkedHashMap.put("Maria", 27);
        linkedHashMap.put("Toni", 27);
        System.out.println("Display linkedhashmap: ");
        System.out.println(linkedHashMap);
        System.out.println(linkedHashMap.get("Toni"));
    }
}
