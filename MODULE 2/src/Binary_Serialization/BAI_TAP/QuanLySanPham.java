package Binary_Serialization.BAI_TAP;

import ACCESSMODIFIER_STATIC.THUC_HANH.back1.A;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySanPham {
    List<Product> listProduct = new ArrayList<>();
    String path = "src/Binary_Serialization/BAI_TAP/save.txt";
    public void disPlay(){
        System.out.println(listProduct);
    }
    public void menu(){
        System.out.println("1. Add product :");
        System.out.println("2. Find product:");
        System.out.println("3. Exit menu.");
    }
    public void addProduct(){
        Scanner input = new Scanner(System.in);
        System.out.println("input id");
        int id = input.nextInt();
        input.skip("\\R");
        System.out.println("input Name");
        String name = input.nextLine();
        System.out.println("input Price");
        int price = input.nextInt();
        Product product = new Product(id,name,price);
        listProduct.add(product);
        writeFile(path,listProduct);
        disPlay();
        menu();
    }
    public void findProduct(){
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        for (Product x:listProduct) {
         if ((x.getName()).equals(name)){
             System.out.println(x);
         }
        }
        menu();
    }
    public  void  writeFile(String path,List<Product> products){
  try {
      FileOutputStream outputStream = new FileOutputStream(path);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
      objectOutputStream.writeObject(products);
      outputStream.close();
      objectOutputStream.close();
  } catch (FileNotFoundException e) {
      e.printStackTrace();
  } catch (IOException e) {
      e.printStackTrace();
  }
    }
    public void readFile(String path){
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            listProduct = (List<Product>) objectInputStream.readObject();
            System.out.println(listProduct);
            fileInputStream.close();
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
