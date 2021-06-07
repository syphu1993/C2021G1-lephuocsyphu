package customer.model.repository;

import customer.model.bean.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    static BaseRepository baseRepository = new BaseRepository();
    private static final String FIND_ALL_CUSTOMER_SQL = "select c.customer_id,ct.Customer_type_name,c.Customer_name,c.Customer_gender,c.Customer_phone,c.Customer_email,c.Customer_address\n" +
            "from customer c join customer_type ct on c.Customer_type_id = ct.Customer_type_id;";

    private static final String CREATE_CUSTOMER_SQL = "insert into Customer (Customer_type_id,Customer_name,Customer_birthday,Customer_gender,Customer_id_card,\n" +
            "Customer_phone,Customer_email,Customer_address)\n" +
            "value(?,?,?,?,?,?,?,?);";

    private static final String UPDATE_CUSTOMER_SQL ="update customer\n" +
            "set Customer_type_id=?,Customer_name=?,Customer_birthday=?,Customer_gender=?,Customer_id_card=?,\n" +
            "Customer_phone=?,Customer_email=?,Customer_address=?\n" +
            "where customer_id =?;";

    private static final String FIND_CUSTOMER_BY_ID_SQL ="select c.customer_id,ct.Customer_type_name,c.Customer_name,c.Customer_birthday,c.Customer_gender,c.Customer_id_card,c.Customer_phone,c.Customer_email,c.Customer_address\n" +
            "from customer c join customer_type ct on c.Customer_type_id = ct.Customer_type_id\n" +
            "where c.customer_id =?;";

    private static final String DEL_CUSTOMER_BY_ID_SQL ="delete from customer\n" +
            "where customer_id =?;";

    private static final String SEARCH_CUSTOMER_BY_NAME="select c.customer_id,ct.Customer_type_name,c.Customer_name,c.Customer_gender,c.Customer_phone,c.Customer_email,c.Customer_address\n" +
            "from customer c join customer_type ct on c.Customer_type_id = ct.Customer_type_id\n" +
            "where c.Customer_name like ? ;";

    private static final String SELECT_CUSTOMER_TYPE_SQL ="select customer_type.Customer_type_name\n" +
            "from customer_type;";

    public static List<Customer> findAll() {
        Connection connection = baseRepository.connectDataBase();
        List<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CUSTOMER_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                String type = resultSet.getString("Customer_type_name");
                String name = resultSet.getString("Customer_name");
                String gender = resultSet.getString("Customer_gender");
                String phone = resultSet.getString("Customer_phone");
                String email = resultSet.getString("Customer_email");
                String address = resultSet.getString("Customer_address");
                Customer customer = new Customer(id, type, name, gender,phone,email,address);
                customers.add(customer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
    public void save(Customer customer) {
    Connection connection = baseRepository.connectDataBase();
    List<String> listType = findAllTypeCustomer();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CUSTOMER_SQL);
            for (int i = 0; i <listType.size() ; i++) {
                if (customer.getTypeOfCustomer().equals(listType.get(i))){
                    preparedStatement.setInt(1,(i+1));
                }
            }
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setString(3,customer.getBirthday());
            preparedStatement.setString(4,customer.getGender());
            preparedStatement.setString(5,customer.getIdCard());
            preparedStatement.setString(6,customer.getPhone());
            preparedStatement.setString(7,customer.getEmail());
            preparedStatement.setString(8,customer.getAddress());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean update(Customer customer){
        Connection connection =baseRepository.connectDataBase();
        List<String>  listType = findAllTypeCustomer();
        boolean check=false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);
            for (int i = 0; i <listType.size() ; i++) {
                if (customer.getTypeOfCustomer().equals(listType.get(i))){
                    preparedStatement.setInt(1,(i+1));
                }
            }
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setString(3,customer.getBirthday());
            preparedStatement.setString(4,customer.getGender());
            preparedStatement.setString(5,customer.getIdCard());
            preparedStatement.setString(6,customer.getPhone());
            preparedStatement.setString(7,customer.getEmail());
            preparedStatement.setString(8,customer.getAddress());
            preparedStatement.setInt(9,customer.getId());
            check =preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
    public Customer findById(int id) {
        Customer customer  = null;
        Connection connection =baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CUSTOMER_BY_ID_SQL);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id1 = resultSet.getInt("customer_id");
                String typeOfCustomer = resultSet.getString("Customer_type_name");
                String name = resultSet.getString("Customer_name");
                String birthday = resultSet.getString("Customer_birthday");
                String gender = resultSet.getString("Customer_gender");
                String idCard = resultSet.getString("Customer_id_card");
                String phone = resultSet.getString("Customer_phone");
                String email = resultSet.getString("Customer_email");
                String address = resultSet.getString("Customer_address");
                customer = new Customer(id1, typeOfCustomer, name, birthday,gender,idCard,phone,email,address);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
    public boolean delete(int id) {
        Connection connection =baseRepository.connectDataBase();
        boolean check=false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DEL_CUSTOMER_BY_ID_SQL);
            preparedStatement.setInt(1,id);
            check =preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
    public static List<Customer> findByName(String name) {
        Connection connection =baseRepository.connectDataBase();
        List<Customer> customers = new ArrayList<>();
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER_BY_NAME);
            preparedStatement.setString(1,"%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                String type = resultSet.getString("Customer_type_name");
                String name1 = resultSet.getString("Customer_name");
                String gender = resultSet.getString("Customer_gender");
                String phone = resultSet.getString("Customer_phone");
                String email = resultSet.getString("Customer_email");
                String address = resultSet.getString("Customer_address");
                customer = new Customer(id, type, name1, gender,phone,email,address);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return customers;
    }
    public static List<String> findAllTypeCustomer() {
        Connection connection = baseRepository.connectDataBase();
        List<String> listTypeCustomers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_TYPE_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String typeName = resultSet.getString("Customer_type_name");
              listTypeCustomers.add(typeName);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTypeCustomers;
    }

    public static void main(String[] args) {
        System.out.println(findAll());
    }

}
