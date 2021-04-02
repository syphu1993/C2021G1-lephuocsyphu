import java.util.Scanner;

public class doiNhietDo {
    public static double celToFah(double cel){
      double fah = (9.0/5)*cel+32;
      return fah;
    }
    public static double fahToCel(double fah){
      double cel = (5.0/9)*(fah-32);
      return cel;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double cel;
        double fah;
        int choice;
        do {
            System.out.println("Menu.");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice){
                case 1:
                    System.out.println("input cel : ");
                    cel = Double.parseDouble(input.nextLine());
                    System.out.println(cel+" độ C = "+celToFah(cel)+ " độ F");
                    break;
                case 2:
                    System.out.println("input fah : ");
                    fah = Double.parseDouble(input.nextLine());
                    System.out.println(fah+" độ F = "+fahToCel(fah)+ " độ C");
                    break;
                case 3:
                    System.out.println("Final.");
                    break;
            }
        }while (choice!=3);

    }
}
