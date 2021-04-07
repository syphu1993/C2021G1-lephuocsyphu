import java.util.Scanner;

public class demKiTu {
    public static void main(String[] args) {
        String string = "lephuocsyphuphule";
        String kiTu;
        int count =0;
        Scanner input = new Scanner(System.in);
        System.out.println("input word: ");
        kiTu =input.nextLine();
        for (int i = 0; i <string.length() ; i++) {
         if(kiTu.equals(String.valueOf(string.charAt(i)))){
             count++;
         }
        }
        System.out.println(kiTu +" xuat hien "+ count + " lan trong chuoi" + string);
    }
}
