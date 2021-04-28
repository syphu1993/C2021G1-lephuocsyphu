package STRING_REGEX.BAI_TAP;

import java.util.Scanner;

public class CheckNameClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean check;
        System.out.println("Input Class Name :");
        do {
            String nameClass = scanner.nextLine();
            ClassName className =new ClassName();
            check =className.checkName(nameClass);
            System.out.println(check);
        }while (!check);
    }
}
