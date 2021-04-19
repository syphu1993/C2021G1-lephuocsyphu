package COLECTION_FRAMEWORK.BAI_TAP;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager {
    static ArrayList<Product> listProduct = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    public void sortProduc(){
        listProduct.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice()-o2.getPrice();
            }
        });
    }

    public void disPlay() {
        sortProduc();
        System.out.println(listProduct);
    }

    public void addProduc() {
        Product product = new Product();
        System.out.println("INPUT ID");
        int id = input.nextInt();
        input.skip("\\R");
        product.setId(id);
        System.out.println("INPUT NAME");
        String name = input.nextLine();
        product.setName(name);
        System.out.println("INPUT PRICE");
        int price = input.nextInt();
        product.setPrice(price);
        listProduct.add(product);
        disPlay();
    }
    public void removeProduct(int id){
        for (int i =0; i<listProduct.size();i++) {
            if (listProduct.get(i).getId() == id){
                listProduct.remove(listProduct.get(i));
            }
        }
        disPlay();
    }
    public void setProduct(int id){
        for (int i = 0; i <listProduct.size() ; i++) {
            if (listProduct.get(i).getId()==id){
                System.out.println("1: edit id :");
                System.out.println("2: edit name :");
                System.out.println("3: edit price :");
                int choose;
                do {
                    choose = input.nextInt();
                    switch (choose){
                        case 1:
                            System.out.println("INPUT ID");
                            int idd = input.nextInt();
                            input.skip("\\R");
                            (listProduct.get(i)).setId(idd);
                            break;
                        case 2:
                            System.out.println("INPUT NAME");
                            String name = input.nextLine();
                            (listProduct.get(i)).setName(name);
                            break;
                        case 3:
                            System.out.println("INPUT PRICE");
                            int price = input.nextInt();
                            (listProduct.get(i)).setPrice(price);
                            break;
                        case 4:
                            System.out.println(" canle !!");
                            break;
                        default:
                            System.out.println("No choose");
                    }
                }while (choose!=4);
            }
        }
        disPlay();
    }
    public void findProduct(String name){
        for (Product product:listProduct) {
            if (product.getName().equals(name)){
                System.out.println(product);
            }
        }
    }
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1> Add products:");
        System.out.println("2> Dellete product:");
        System.out.println("3> Find product:");
        System.out.println("4> Edit product:");
        System.out.println("5> Cancle Menu:");
        System.out.println("Input choose:");
    }

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.menu();
        int choose ;
        Scanner scanner = new Scanner(System.in);
 do {
     choose = scanner.nextInt();
     switch (choose){
         case 1:
             productManager.addProduc();
             productManager.menu();
             break;
         case 2:
             System.out.println("iput id  you want to del");
             int idDel = scanner.nextInt();
             productManager.removeProduct(idDel);
             productManager.menu();
             break;
         case 3:
             scanner.skip("\\R");
             String name = scanner.nextLine();
             productManager.findProduct(name);
             productManager.menu();
             break;
         case 4:
             System.out.println(" input id you want to edit:");
             int idSet = scanner.nextInt();
             productManager.setProduct(idSet);
             productManager.menu();
             break;
         case 5:
             System.exit(5);
         default:
             System.out.println("No choose!");
             productManager.menu();
     }
 }while (choose!=5);
    }
}
