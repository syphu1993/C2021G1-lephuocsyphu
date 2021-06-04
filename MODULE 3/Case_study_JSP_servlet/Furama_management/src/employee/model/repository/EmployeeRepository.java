package employee.model.repository;

import customer.model.bean.Customer;
import employee.model.bean.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    static BaseRepository baseRepository = new BaseRepository();
    private static final String FIND_ALL_EMPLOYEE_SQL ="select e.employee_id, e.employee_name, e.employee_phone, e.employee_address, p.Position_name, \n" +
            "ed.Education_degree_name, d.Division_name\n" +
            "from employee e join position p on e.Position_id = p.Position_id\n" +
            "join education_degree ed on e.Education_degree_id = ed.Education_degree_id\n" +
            "join division d on e.Division_id = d.Division_id\n" +
            "join `user` u on u.username = e.username;";

    private static final String CREATE_EMPLOYEE_SQL = "insert into employee(employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,\n" +
            " employee_email,employee_address,Position_id,Education_degree_id,Division_id,username)\n" +
            " value(?,?,?,?,?,?,?,?,?,?,?);";

    private static final String CREATE_USER_SQL ="insert into `User`\n" +
            "value(?,'123');";

    private static final String FIND_EMPLOYEE_BY_ID_SQL ="select e.employee_id, e.employee_name, e.employee_birthday,e.employee_id_card,e.employee_salary, e.employee_phone,\n" +
            "e.employee_email, e.employee_address, p.Position_name, ed.Education_degree_name, d.Division_name, e.username\n" +
            "from employee e join position p on e.Position_id = p.Position_id\n" +
            "join education_degree ed on e.Education_degree_id = ed.Education_degree_id\n" +
            "join division d on e.Division_id = d.Division_id\n" +
            "join `user` u on u.username = e.username\n" +
            "where e.employee_id =?;";

    private static final String UPDATE_EMPLOYEE_BY_ID_SQL ="update employee\n" +
            "set employee_name=?, employee_birthday=?, employee_id_card=?,\n" +
            "employee_salary=?, employee_phone =?, employee_email=?,\n" +
            " employee_address=?, Position_id=?, Education_degree_id=?, Division_id=?\n" +
            " where employee_id =?;";

    private static final String DEL_EMPLOYEE_BY_ID="delete from employee\n" +
            "where employee_id=?;";

    private static final String SEARCH_EMPLOYEE_BY_NAME_SQL ="select e.employee_id, e.employee_name, e.employee_phone, e.employee_address, p.Position_name, \n" +
            "ed.Education_degree_name, d.Division_name\n" +
            "from employee e join position p on e.Position_id = p.Position_id\n" +
            "join education_degree ed on e.Education_degree_id = ed.Education_degree_id\n" +
            "join division d on e.Division_id = d.Division_id\n" +
            "join `user` u on u.username = e.username\n" +
            "where e.employee_name like ?;";

    public List<Employee> findAll() {
        Connection connection = baseRepository.connectDataBase();
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_EMPLOYEE_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String phone = resultSet.getString("employee_phone");
                String address = resultSet.getString("employee_address");
                String position = resultSet.getString("Position_name");
                String degree = resultSet.getString("Education_degree_name");
                String division = resultSet.getString("Division_name");
                Employee employee = new Employee(id, name, phone, address,position,degree,division);
                employees.add(employee);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
    public void save(Employee employee) {
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatementUser = connection.prepareStatement(CREATE_USER_SQL);
            preparedStatementUser.setString(1,employee.getUsername());
            preparedStatementUser.executeUpdate();
            preparedStatementUser.close();

            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_EMPLOYEE_SQL);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getBirthday());
            preparedStatement.setString(3,employee.getIdCard());
            preparedStatement.setDouble(4,employee.getSalary());
            preparedStatement.setString(5,employee.getPhone());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setString(7,employee.getAddress());
            if (employee.getPosition().equals("Manager")){
                preparedStatement.setInt(8,1);
            } else if (employee.getPosition().equals("Staff")){
                preparedStatement.setInt(8,2);
            }
            if (employee.getDegree().equals("Vocational")){
                preparedStatement.setInt(9,1);
            } else if (employee.getDegree().equals("College")){
                preparedStatement.setInt(9,2);
            }
            if (employee.getDivision().equals("Receptionist")){
                preparedStatement.setInt(10,1);
            } else if (employee.getDivision().equals("Housekeeping")){
                preparedStatement.setInt(10,2);
            }else if (employee.getDivision().equals("Office")){
                preparedStatement.setInt(10,3);
            }
            preparedStatement.setString(11,employee.getUsername());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Employee findById(int id) {
        Employee employee  = null;
        Connection connection =baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_EMPLOYEE_BY_ID_SQL);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id1 = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String card = resultSet.getString("employee_id_card");
                double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                String position = resultSet.getString("Position_name");
                String degree = resultSet.getString("Education_degree_name");
                String division = resultSet.getString("Division_name");
                String username = resultSet.getString("username");
                employee = new Employee(id1,name,birthday,card,salary,phone,email,address,position,degree,division,username);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
    public boolean update(Employee employee) {
        Connection connection =baseRepository.connectDataBase();
        boolean check=false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_BY_ID_SQL);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getBirthday());
            preparedStatement.setString(3,employee.getIdCard());
            preparedStatement.setDouble(4,employee.getSalary());
            preparedStatement.setString(5,employee.getPhone());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setString(7,employee.getAddress());
            if (employee.getPosition().equals("Manager")){
                preparedStatement.setInt(8,1);
            } else if (employee.getPosition().equals("Staff")){
                preparedStatement.setInt(8,2);
            }
            if (employee.getDegree().equals("Vocational")){
                preparedStatement.setInt(9,1);
            } else if (employee.getDegree().equals("College")){
                preparedStatement.setInt(9,2);
            }
            if (employee.getDivision().equals("Receptionist")){
                preparedStatement.setInt(10,1);
            } else if (employee.getDivision().equals("Housekeeping")){
                preparedStatement.setInt(10,2);
            }else if (employee.getDivision().equals("Office")){
                preparedStatement.setInt(10,3);
            }
            preparedStatement.setInt(11,employee.getId());
            check =preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
    public boolean delete(int id) {
        Connection connection =baseRepository.connectDataBase();
        boolean check=false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DEL_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1,id);
            check =preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
    public List<Employee> findByName(String name) {
        Connection connection =baseRepository.connectDataBase();
        List<Employee> employees = new ArrayList<>();
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_EMPLOYEE_BY_NAME_SQL);
            preparedStatement.setString(1,"%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name1 = resultSet.getString("employee_name");
                String phone = resultSet.getString("employee_phone");
                String address = resultSet.getString("employee_address");
                String position = resultSet.getString("Position_name");
                String degree = resultSet.getString("Education_degree_name");
                String division = resultSet.getString("Division_name");
                employee = new Employee(id, name1, phone, address,position,degree,division);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return employees;
    }

}
