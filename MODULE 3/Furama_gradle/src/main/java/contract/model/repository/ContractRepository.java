package contract.model.repository;

import contract.model.bean.Contract;
import contract.model.bean.ContractDetail;
import contract.model.bean.ContractUseAttachService;
import customer.model.bean.Customer;
import employee.model.bean.Employee;
import service.model.bean.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository {
    static BaseRepository  baseRepository = new BaseRepository();

    private static final String FIND_ALL_CONTRACT_SQL ="select ct.contract_id, ct.contract_start_date,ct.contract_end_date,ct.contract_deposit,ct.contract_total_money\n" +
            "from contract ct join employee ep on ct.employee_id = ep.employee_id\n" +
            "join customer cs on cs.customer_id = ct.customer_id\n" +
            "join service sv on sv.service_id = ct.service_id;";

    private static final String FIND_ALL_EMPLOYEE_SQL = "select employee_id,employee_name\n" +
            "from employee;";

    private static final String FIND_ALL_CUSTOMER_SQL = "select customer_id, customer_name\n" +
            "from customer;";

    private static final String FIND_ALL_SERVICE_SQL = "select service_id, service_name\n" +
            "from service;";

    private static final String CREATE_CONTRACT_SQL = " insert into contract(contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,\n" +
            "  customer_id,service_id)\n" +
            "  value(?,?,?,?,?,?,?);";

    private static final String FIND_CONTRACT_BY_ID_SQL ="select *\n" +
            "from contract\n" +
            "where contract_id = ?;";

    private static final String FIND_ATTACH_SERVICE_SQL ="select attach_service_id,attach_service_name\n" +
            "from attach_service;";

    private static final String CREATE_CONTRACTDATAIL_SQL ="insert into contract_detail(contract_id,attach_service_id,quantity)\n" +
            "value(?,?,?);";

    private static final String FIND_CUSTOMER_USE_SERVICE_SQL ="select ctm.customer_id, ctm.Customer_name,sv.service_name, \n" +
            "GROUP_CONCAT(ats.attach_service_name SEPARATOR ', ') as List_attach,ct.contract_id\n" +
            "from customer ctm join contract ct on ctm.customer_id = ct.customer_id\n" +
            "join service sv on sv.service_id = ct.service_id\n" +
            "left join contract_detail ctd on ct.contract_id = ctd.contract_id\n" +
            "left join attach_service ats on ctd.attach_service_id = ats.attach_service_id\n" +
            "group by ctm.Customer_name;";

    private static final String DEL_CONTRACT_SQL ="delete from contract\n" +
            "where contract_id = ?;";

    private static final String DEL_CONTRACT_DETAIL_SQL ="delete from contract_detail\n" +
            "where contract_id = ?;";

    public static List<Contract> findAll() {
        Connection connection = baseRepository.connectDataBase();
        List<Contract> contracts = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CONTRACT_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("contract_id");
                String startDay = resultSet.getString("contract_start_date");
                String endDay = resultSet.getString("contract_end_date");
                double deposit = resultSet.getDouble("contract_deposit");
                double total = resultSet.getDouble("contract_total_money");
                Contract contract = new Contract(id, startDay, endDay, deposit,total);
                contracts.add(contract);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contracts;
    }

    public static List<Employee> findEmployee() {
        Connection connection = baseRepository.connectDataBase();
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_EMPLOYEE_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                Employee employee = new Employee(id,name);
                employees.add(employee);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static List<Customer> findCustomer() {
        Connection connection = baseRepository.connectDataBase();
        List<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CUSTOMER_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                Customer customer = new Customer(id,name);
                customers.add(customer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static List<Service> findService() {
        Connection connection = baseRepository.connectDataBase();
        List<Service> services = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SERVICE_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("service_id");
                String name = resultSet.getString("service_name");
                Service service = new Service(id,name);
                services.add(service);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    public void save(Contract contract) {
    Connection connection = baseRepository.connectDataBase();
    List<Contract> contracts =findAll();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CONTRACT_SQL);
            preparedStatement.setString(1,contract.getStartDay());
            preparedStatement.setString(2,contract.getEndDay());
            preparedStatement.setDouble(3,contract.getDeposit());
            preparedStatement.setDouble(4,contract.getTotalMoney());
            preparedStatement.setInt(5,contract.getIdEmployee());
            preparedStatement.setInt(6,contract.getIdCustomer());
            preparedStatement.setInt(7,contract.getIdService());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Contract findContractByID(int id) {
        Connection connection= baseRepository.connectDataBase();
        Contract contract = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CONTRACT_BY_ID_SQL);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id1 = resultSet.getInt("contract_id");
                String start = resultSet.getString("contract_start_date");
                String end = resultSet.getString("contract_end_date");
                double deposit = resultSet.getDouble("contract_deposit");
                double total = resultSet.getDouble("contract_total_money");
                contract = new Contract(id1, start, end, deposit,total);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contract;
    }

    public static List<String[]> findAttachService() {
        Connection connection = baseRepository.connectDataBase();
        List<String[]> listAttachService = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ATTACH_SERVICE_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("attach_service_id");
                String name = resultSet.getString("attach_service_name");
                String[] stringAttach = {id,name};
                listAttachService.add(stringAttach);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAttachService;
    }

    public void creatContractDetail(ContractDetail contractDetail) {
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CONTRACTDATAIL_SQL);
            preparedStatement.setInt(1,contractDetail.getMainContractId());
            preparedStatement.setInt(2,contractDetail.getAttachServiceId());
            preparedStatement.setInt(3,contractDetail.getQuantity());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ContractUseAttachService> findAllCustomerUseService() {
        Connection connection = baseRepository.connectDataBase();
        List<ContractUseAttachService> contractUseAttachServices = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CUSTOMER_USE_SERVICE_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCu= resultSet.getInt("customer_id");
                String nameCustomer = resultSet.getString("Customer_name");
                String nameService = resultSet.getString("service_name");
                String attach = resultSet.getString("List_attach");
                int idCo = resultSet.getInt("contract_id");
                ContractUseAttachService contractUseAttachService = new ContractUseAttachService(idCo,idCu,nameCustomer,nameService,attach);
                contractUseAttachServices.add(contractUseAttachService);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractUseAttachServices;
    }
    public boolean delete(int id) {
        Connection connection =baseRepository.connectDataBase();
        boolean check=false;
        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement(DEL_CONTRACT_DETAIL_SQL);
            preparedStatement1.setInt(1,id);
            check =preparedStatement1.executeUpdate()>0;
            preparedStatement1.close();

            PreparedStatement preparedStatement = connection.prepareStatement(DEL_CONTRACT_SQL);
            preparedStatement.setInt(1,id);
            check =preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

//    public static void main(String[] args) {
//        System.out.println(findAllCustomerUseService());
//    }
}
