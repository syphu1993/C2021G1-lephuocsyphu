package management.product.model.repository;

import management.product.model.bean.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductRepository {
     static BaseReponsitory baseReponsitory = new BaseReponsitory();

    private static final String FIND_ALL_PRO_SQL ="select pr.id,pr.`name`,pr.price,pr.quanlity,pr.color,c.name_catelogy\n" +
            "from products pr join catelogy c on pr.id_catelogy = c.id_catelogy;";

    private static final String FIND_CATE_PRO_SQL ="select name_catelogy\n" +
            "from catelogy;";

    private static final String INS_PRO_PRO_SQL ="insert into products(`name`,price,quanlity,color,decription,id_catelogy)\n" +
            "value(?,?,?,?,?,?);\n";

    private static final String DEL_PRO_PRO_SQL ="delete from products\n" +
            "where id = ?;";

    private static final String FIND_PRO_PRO_SQL ="select pr.id,pr.`name`,pr.price,pr.quanlity,pr.color,c.name_catelogy\n" +
            "from products pr join catelogy c on pr.id_catelogy = c.id_catelogy\n" +
            "where pr.`name` like ?;";

    public static List<Product> findAll() {
        Connection connection = baseReponsitory.connectDataBase();
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_PRO_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quan = resultSet.getInt("quanlity");
                String collor = resultSet.getString("color");
                String cate = resultSet.getString("name_catelogy");
                Product product = new Product(id, name, price, quan,collor,cate);
                products.add(product);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<String> findCate() {
        Connection connection = baseReponsitory.connectDataBase();
        List<String> Cates = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CATE_PRO_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String cate = resultSet.getString("name_catelogy");
                Cates.add(cate);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Cates;
    }
    public void save(Product product) {
        Connection connection = baseReponsitory.connectDataBase();
        List<String> cates = findCate();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INS_PRO_PRO_SQL);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuanlity());
            preparedStatement.setString(4,product.getCollor());
            preparedStatement.setString(5,product.getDecrip());
            for (int i = 0; i <cates.size() ; i++) {
                preparedStatement.setInt(6,(1+i));
            }
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean delete(int id) {
        Connection connection =baseReponsitory.connectDataBase();
        boolean check=false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DEL_PRO_PRO_SQL);
            preparedStatement.setInt(1,id);
            check =preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public List<Product> findByName(String name) {
        Connection connection =baseReponsitory.connectDataBase();
        List<Product> products = new ArrayList<>();
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_PRO_PRO_SQL);
            preparedStatement.setString(1,"%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quan = resultSet.getInt("quanlity");
                String collor = resultSet.getString("color");
                String cate = resultSet.getString("name_catelogy");
                product = new Product(id, name1, price, quan,collor,cate);
                products.add(product);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return products;
    }

//    public static void main(String[] args) {
//        System.out.println(findAll());
//    }
}
