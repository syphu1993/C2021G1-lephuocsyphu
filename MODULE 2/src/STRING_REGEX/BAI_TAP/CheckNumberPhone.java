package STRING_REGEX.BAI_TAP;

import java.util.Scanner;

public class CheckNumberPhone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean check;
        System.out.println("Input Class Number :");
        do {
            String numberPhone = scanner.nextLine();
            ClassPhone classPhone =new ClassPhone();
            check =classPhone.checkNumber(numberPhone);
            System.out.println(check);
        }while (!check);
    }
}
