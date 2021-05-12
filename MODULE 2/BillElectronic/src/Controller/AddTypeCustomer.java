package Controller;

import Commons.ReadWriteFile;
import Commons.Validator;
import Models.Customer;
import Models.ForeignCustomer;
import Models.VietNamCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddTypeCustomer {
    private static Scanner scanner = new Scanner(System.in);

    public static void addVietNamCustomer() {
        String codeCustomer;
        do{
            System.out.println("Nhập mã khách hàng:");
            codeCustomer = scanner.nextLine();
        }while (!Validator.isValidatorID(codeCustomer,Validator.IDVNCUSTOMER_REGET));

        String fullNameCustomer;
        System.out.println("Nhập họ tên khách hàng:");
        fullNameCustomer = scanner.nextLine();
        String typeOfCustomer = null;
        System.out.println("Danh sách loại khách hàng: ");
        List<String> listTypeCustomer = ReadWriteFile.readTypeVnCustomer(ReadWriteFile.path2);
        for (int i = 0; i < listTypeCustomer.size(); i++) {
            System.out.println(i + 1);
            System.out.println(listTypeCustomer.get(i));
        }
        int choose = 0;
        System.out.println("Chọn loại khách hàng!");
        choose = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < listTypeCustomer.size(); i++) {
            if (i == choose - 1) {
                typeOfCustomer = (listTypeCustomer.get(choose - 1).split(","))[1];
            }
        }

        double consumeRate;
        System.out.println("Nhập định mức tiêu thụ:");
        consumeRate = Double.parseDouble(scanner.nextLine());
        Customer vnCustomer = new VietNamCustomer(codeCustomer, fullNameCustomer, typeOfCustomer, consumeRate);
        List<Customer> listVNcustomer = new ArrayList<>();
        listVNcustomer.add(vnCustomer);
        ReadWriteFile.writeFile(listVNcustomer,ReadWriteFile.path1,true);
    }

    public static void addForeignCustomer() {
        String codeCustomer;
        do{
            System.out.println("Nhập mã khách hàng:");
            codeCustomer = scanner.nextLine();
        }while (!Validator.isValidatorID(codeCustomer,Validator.IDFORCUSTOMER_REGET));

        String fullNameCustomer;
        System.out.println("Nhập họ tên khách hàng:");
        fullNameCustomer = scanner.nextLine();
        String nationalForeign;
        System.out.println("Nhập quốc tịch:");
        nationalForeign = scanner.nextLine();
        Customer foreignCustomer = new ForeignCustomer(codeCustomer, fullNameCustomer, nationalForeign);
        List<Customer> listForeignCustomer = new ArrayList<>();
        listForeignCustomer.add(foreignCustomer);
        ReadWriteFile.writeFile(listForeignCustomer,ReadWriteFile.path1,true);
    }
}
