package Commons;

import Models.BillElectronic;
import Models.Customer;
import Models.ForeignCustomer;
import Models.VietNamCustomer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    public static final String path1 = "E:\\CODEGYM\\C2021G1 LEPHUOCSYPHU\\MODULE 2\\BillElectronic\\src\\Data\\khanhHang.csv";
    public static final String path2 = "E:\\CODEGYM\\C2021G1 LEPHUOCSYPHU\\MODULE 2\\BillElectronic\\src\\Data\\loaikhach.csv";
    public static final String path3 = "E:\\CODEGYM\\C2021G1 LEPHUOCSYPHU\\MODULE 2\\BillElectronic\\src\\Data\\hoaDon.csv";
    public static void writeFile(List<Customer> list,String path, boolean isapend) {
        File file = new File(path);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(path, isapend);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer:list) {
              bufferedWriter.write(customer.toString());
              bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Customer> readFile(String path){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line= null;
        String[] content;
        List<Customer> customers = new ArrayList<>();
        try {
            fileReader =new FileReader(path);
            bufferedReader =new BufferedReader(fileReader);
            while ((line= bufferedReader.readLine())!=null){
                content = line.split(",");
                if (content.length==4){
                  Customer vnCustomer = new VietNamCustomer(content[0],content[1],content[2],Double.parseDouble(content[3]));
                  customers.add(vnCustomer);
                } else if (content.length ==3){
                    Customer foreignCustomer = new ForeignCustomer(content[0],content[1],content[2]);
                    customers.add(foreignCustomer);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }
    public static List<String> readTypeVnCustomer(String path){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line= null;
        List<String> content = new ArrayList<>();
        try {
            fileReader=new FileReader(path);
            bufferedReader =new BufferedReader(fileReader);
            while ((line=bufferedReader.readLine())!=null){
                content.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
    public static void writeFileBill(List<BillElectronic> list, String path, boolean isapend) {
        File file = new File(path);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(path, isapend);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (BillElectronic bill:list) {
                bufferedWriter.write(bill.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {

    }
    }
    public static List<BillElectronic> readFileBill(String path){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line= null;
        String[] content;
        List<BillElectronic> bills = new ArrayList<>();
        try {
            fileReader =new FileReader(path);
            bufferedReader =new BufferedReader(fileReader);
            while ((line= bufferedReader.readLine())!=null){
                content = line.split(",");
              BillElectronic bill = new BillElectronic(content[0],content[1],content[2],Double.parseDouble(content[3]),Double.parseDouble(content[4]),Double.parseDouble(content[5]));
              bills.add(bill);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Danh sach trong!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bills;
    }
    public static void writeFileReset(String path) {
        File file = new File(path);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(path, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");
            bufferedWriter.close();
        } catch (IOException e) {

        }
    }
}
