package model.reponsitory;

import model.bean.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductReponsitory {
    static Map<String, Product> mapProduct = new HashMap<>();
    static {
        mapProduct.put("1",new Product("1","NokiaPlus","Nokia",1200000));
        mapProduct.put("2",new Product("2","Note8","SamSung",1500000));
        mapProduct.put("3",new Product("3","Iphonex","Apple",1600000));
        mapProduct.put("4",new Product("4","OppleX","Opple",2000000));
        mapProduct.put("5",new Product("5","Lenovo12","Lenovo",1500000));
    }
    public List<Product> findByAll(){
        return new ArrayList<>(mapProduct.values());
    }
    public Product findById(String id){
        return mapProduct.get(id);
    }
    public void update(String id, Product product){
        mapProduct.put(id,product);
    }
    public void add(Product product){
        mapProduct.put(product.getId(),product);
    }
    public  void remove(String id){
        mapProduct.remove(id);
    }

}
