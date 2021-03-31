import java.util.Scanner;

public class ChiSoCanNang {
    public static void main(String[] args) {
        float weight;
        float height;
        double bmi;
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập cân nặng");
        weight = Float.parseFloat(scanner.nextLine());
        System.out.println("nhập chiều cao");
        height = Float.parseFloat(scanner.nextLine());
        bmi = weight/(Math.pow(height,2));
        if(bmi<18.5){
            System.out.println("Underweight");
        } else if(bmi>=18.5 && bmi < 25){
            System.out.println("Normal");
        } else if (bmi>=25 && bmi<30){
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}
