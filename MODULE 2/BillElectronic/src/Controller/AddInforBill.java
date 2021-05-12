package Controller;

import Commons.ReadWriteFile;
import Models.BillElectronic;
import Models.Customer;
import Models.VietNamCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddInforBill {
    private static Scanner scanner = new Scanner(System.in);

    public static void addBill() {
        List<BillElectronic> listBillRead = ReadWriteFile.readFileBill(ReadWriteFile.path3);
        String codeBill=null;
        int size = listBillRead.size() +1;
        System.out.println( "size" + size);
        codeBill = "MHD-00"+String.valueOf(size);
        List<Customer> customers = new ArrayList<>();
        customers = ReadWriteFile.readFile(ReadWriteFile.path1);
        String idCustomer = null;
        System.out.println("Chọn khách hàng:");
        int choose = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < customers.size(); i++) {
            if (i == choose - 1) {
                idCustomer = (customers.get(i)).getCodeCustomer();
                break;
            }
        }
        String dateMade = null;
        System.out.println("Nhập ngày xuất hóa đơn.");
        dateMade = scanner.nextLine();
        double countPoinKW = 0;
        System.out.println("Nhập số chữ điện:");
        countPoinKW = Integer.parseInt(scanner.nextLine());
        double priceOfone=0.0;
        try{
            System.out.println("Nhập đơn giá điên:");
            priceOfone = Double.parseDouble(scanner.nextLine());
        }catch (Exception e){
            e.getMessage();
        }

        double sumPayingBill = 0;
        for (Customer customer : customers) {
            if (customer.getCodeCustomer().contains("VN")) {
                double rate = ((VietNamCustomer) customer).getConsumeRate();
                if (rate >= countPoinKW) {
                    sumPayingBill = countPoinKW * priceOfone;
                } else {
                    sumPayingBill = countPoinKW * priceOfone * rate + (rate - countPoinKW) * priceOfone * 2.5;
                }
            } else if (customer.getCodeCustomer().contains("NN")) {
                sumPayingBill = countPoinKW * priceOfone;
            }
        }
        BillElectronic newBill = new BillElectronic(codeBill,idCustomer,dateMade,countPoinKW,priceOfone,sumPayingBill);
        List<BillElectronic> listBillWrite = new ArrayList<>();
        listBillWrite.add(newBill);
        ReadWriteFile.writeFileBill(listBillWrite,ReadWriteFile.path3,true);
    }
}
