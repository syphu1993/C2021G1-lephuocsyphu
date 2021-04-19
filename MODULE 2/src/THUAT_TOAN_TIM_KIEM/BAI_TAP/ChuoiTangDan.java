package THUAT_TOAN_TIM_KIEM.BAI_TAP;

import java.util.ArrayList;
import java.util.LinkedList;

public class ChuoiTangDan {
    public static void main(String[] args) {
        String string = "HWellcom";
        LinkedList<Character> stringMax = new LinkedList<>();
        for (int i = 0; i <string.length() ; i++) {
           LinkedList<Character> tempList= new LinkedList<>() ;
           tempList.add(string.charAt(i));
            for (int j = i+1; j < string.length(); j++) {
                if (string.charAt(j)>tempList.getLast()){
                    tempList.add(string.charAt(j));
                }
            }if (tempList.size()>stringMax.size()){
                stringMax.clear();
                stringMax.addAll(tempList);
            }
            tempList.clear();
        }
        for (Character x:stringMax) {
            System.out.println(x);
        }
    }
}
