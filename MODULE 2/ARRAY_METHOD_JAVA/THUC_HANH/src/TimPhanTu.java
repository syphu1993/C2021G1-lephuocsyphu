import com.sun.scenario.effect.impl.state.AccessHelper;

import java.util.Scanner;

public class TimPhanTu {
    public static void main(String[] args) {
        String[] listStuden={"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        String searchStudent;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search name student:");
        searchStudent = scanner.nextLine();
        boolean check= false;
        for (int i = 0; i < listStuden.length; i++) {
            if (listStuden[i].equals(searchStudent)){
                System.out.println(searchStudent+" nằm vị trí thứ :" + (i+1));
                check = true;
                break;
            }
        }
        if(check == false){
            System.out.println(searchStudent+" no in list");
        }

    }
}
