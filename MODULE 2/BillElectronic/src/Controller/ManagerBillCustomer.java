package Controller;

import Commons.ReadWriteFile;
import Models.BillElectronic;
import Models.Customer;
import Models.ForeignCustomer;
import Models.VietNamCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerBillCustomer {
    public static void main(String[] args) {
        diplayMenu();
    }
    private static Scanner scanner = new Scanner(System.in);
    private static boolean isExit;
    private static boolean isBackMenu;
    public static void diplayMenu() {
        String choose = null;
        do {
            System.out.println("Chọn chức năng:\n" +
                    "1. Thêm mới khách hàng.\n" +
                    "2. Hiện thị thông tin khách hàng\n" +
                    "3. Tìm kiếm khách hàng\n" +
                    "4. Thêm mới hóa đơn\n" +
                    "5. Chỉnh sửa hóa đơn\n" +
                    "6. Hiện thị thông  tin chi tiết hóa đơn\n" +
                    "7. Thoát\n");
            System.out.println(" Vui lòng chọn :");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    addNewCustomer();
                    break;
                case "2":
                    displayInforCustomer();
                    break;
                case "3":
                    findCustomer();
                    break;
                case "4":
                    addNewBill();
                    break;
                case "5":
                    EditBill();
                    break;
                case "6":
                    displayInforBill();
                    break;
                case "7":
                    isExit = true;
                    System.out.println("Kết thúc chọn.");
                    break;
                default:
                    System.out.println("Vui lòng nhập lại:");
                    break;
            }
        } while (!isExit);
    }

    private static void addNewCustomer() {
        String choose = null;
        do {
            System.out.println("1. Thêm khách hàng VN,\n" +
                    "2. Thêm khách hàng nước ngoài, \n"+
                    "3. Quay lại menu, \n"+
                    "4. Thoát, \n");
            System.out.println("Chon thêm khách hàng:");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                   AddTypeCustomer.addVietNamCustomer();
                    isBackMenu = false;
                    break;
                case "2":
                    AddTypeCustomer.addForeignCustomer();
                    isBackMenu = false;
                    break;
                case "3":
                    isBackMenu = true;
                    break;
                case "4":
                    System.out.println("Kết thúc chọn.");
                    isExit = true;
                    break;
                default:
                    System.out.println("Xin vui lòng nhập lại");
                    isBackMenu = false;
                    break;
            }
            if (isExit || isBackMenu) {
                return;
            }
        } while (true);
    }
    private static void displayInforCustomer() {
        List<Customer> customers = new ArrayList<>();
        customers = ReadWriteFile.readFile(ReadWriteFile.path1);
        for (int i = 0; i <customers.size() ; i++) {
            if ((customers.get(i)) instanceof VietNamCustomer){
                System.out.println("Khách hàng thứ: "+ (i+1));
                System.out.println("MKH: "+customers.get(i).getCodeCustomer());
                System.out.println("Tên KH: "+customers.get(i).getFullNameCustomer());
                System.out.println("Loại KH: "+((VietNamCustomer)customers.get(i)).getTypeOfCustomer());
                System.out.println("Định mức tiêu thụ: "+((VietNamCustomer)customers.get(i)).getConsumeRate());
            } else if ((customers.get(i)) instanceof ForeignCustomer){
                System.out.println("Khách hàng thứ: "+ (i+1));
                System.out.println("MKH: "+customers.get(i).getCodeCustomer());
                System.out.println("Tên KH: "+customers.get(i).getFullNameCustomer());
                System.out.println("Quốc tịch KH: "+((ForeignCustomer)customers.get(i)).getNationalForeign());
            }
        }
    }

    private static void findCustomer() {
        List<Customer> customers = new ArrayList<>();
        String nameCustomer = null;
        boolean check = false;
        System.out.println("Nhập tên khách hàng cần tìm:");
        nameCustomer = scanner.nextLine();
        customers = ReadWriteFile.readFile(ReadWriteFile.path1);
        for (int i = 0; i <customers.size() ; i++) {
           if ((customers.get(i)).getFullNameCustomer().equals(nameCustomer)){
               if ((customers.get(i)) instanceof VietNamCustomer ){
                   System.out.println("Khách hàng thứ: "+ (i+1));
                   System.out.println("MKH: "+customers.get(i).getCodeCustomer());
                   System.out.println("Tên KH: "+customers.get(i).getFullNameCustomer());
                   System.out.println("Loại KH: "+((VietNamCustomer)customers.get(i)).getTypeOfCustomer());
                   System.out.println("Định mức tiêu thụ: "+((VietNamCustomer)customers.get(i)).getConsumeRate());
               }else if ((customers.get(i)) instanceof ForeignCustomer){
                   System.out.println("Khách hàng thứ: "+ (i+1));
                   System.out.println("MKH: "+customers.get(i).getCodeCustomer());
                   System.out.println("Tên KH: "+customers.get(i).getFullNameCustomer());
                   System.out.println("Quốc tịch KH: "+((ForeignCustomer)customers.get(i)).getNationalForeign());
               }
               check = true;
           }
        }
        if (check == false){
            System.out.println("Không tìm thấy khách hàng.");
        } else {
            check =false;
        }
    }

    private static void addNewBill() {
        displayInforCustomer();
        AddInforBill.addBill();
    }

    private static void EditBill() {
        List<BillElectronic> listBillRead = ReadWriteFile.readFileBill(ReadWriteFile.path3);
        List<Customer> listCustomer =ReadWriteFile.readFile(ReadWriteFile.path1);
        for (int i = 0; i <listBillRead.size() ; i++) {
            System.out.println((1+i)+": ");
            System.out.println(listBillRead.get(i).showIforBill());
        }
        int choose = 0;
        int chooseNew=0;
        System.out.println("Chọn hóa đơn cần sửa:");
        choose= Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < listBillRead.size(); i++) {
            if (choose-1==i){
                for (int j = 0; j <listCustomer.size() ; j++) {
                    System.out.println((j+1)+": ");
                    System.out.println(listCustomer.get(j).getCodeCustomer());
                }
                System.out.println("Nhập lại mã khách hàng");
                chooseNew = Integer.parseInt(scanner.nextLine());
                for (int k = 0; k <listCustomer.size() ; k++) {
                    if (chooseNew-1==k){
                       listBillRead.get(i).setIdCustomer(listCustomer.get(k).getCodeCustomer());
                       break;
                    }
                }
                break;
            }
        }
        System.out.println(listBillRead);
        ReadWriteFile.writeFileReset(ReadWriteFile.path3);
        ReadWriteFile.writeFileBill(listBillRead,ReadWriteFile.path3,true);
    }
    private static void displayInforBill() {
        List<BillElectronic> listBill = ReadWriteFile.readFileBill(ReadWriteFile.path3);
        List<Customer> listCustomer =ReadWriteFile.readFile(ReadWriteFile.path1);
        for (int i = 0; i <listBill.size() ; i++) {
            System.out.println((1+i)+": ");
            System.out.println(listBill.get(i).showIforBill());
        }
        int choose = 0;
        System.out.println("Chọn bill:");
        choose= Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <listBill.size() ; i++) {
          if (choose-1 == i){
              for (int j = 0; j <listCustomer.size() ; j++) {
                 if ((listBill.get(i).getIdCustomer()).equals(listCustomer.get(j).getCodeCustomer())){
                     listBill.get(i).setCustomer(listCustomer.get(j));
                 }
              }
              System.out.println(listBill.get(i).showIforBillAndCustomer());
          }
        }
    }
}
