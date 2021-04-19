package STACK__QUEUE.BAI_TAP;

import java.util.Map;
import java.util.TreeMap;

public class TreMap {
    public static void main(String[] args) {
        String string = "le phuoc sy phu va le phuoc va va va phu";
        String[] mang  = string.split(" ");
        Map<String,Integer> treeMap = new TreeMap<String, Integer>();
        for (String x: mang) {
           if (treeMap.containsKey(x)){
               treeMap.put(x,treeMap.get(x)+1);
           } else {
               treeMap.put(x,1);
           }
        }
        System.out.println(treeMap);
    }
}
