package service.model.repository;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import customer.model.bean.Customer;
import service.model.bean.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    static BaseRepository baseRepository = new BaseRepository();
    private static final String FIND_ALL_SERVICE_SQL ="select s.service_id,s.service_name,s.service_cost,rt.rent_type_name,st.service_type_name,s.service_max_peple\n" +
            "from service s left join service_type st on s.service_type_id=st.service_type_id\n" +
            "join rent_type rt on rt.rent_type_id =s.rent_type_id;";

    private static final String CREATE_SERVICE_SQL ="insert into service\n" +
            "value(?,?,?,?,?,?,?,?,?,?,?);";

    private static final String UPDATE_SERVICE_SQL ="update service\n" +
            "set service_area = ?,service_cost = ?,service_max_peple=?,rent_type_id = ?,\n" +
            "service_type_id=?,standard_rome = ?, decription_other_convenient = ?,poor_area = ?,number_of_floor = ?\n" +
            "where service_name = ?;";

    private static final String FIND_SERVICE_BUY_NAME_SQL ="select s.service_id,s.service_name, s.service_area, s.service_cost,s.service_max_peple,rt.rent_type_name,st.service_type_name,s.standard_rome,\n" +
            "s.decription_other_convenient,s.poor_area,s.number_of_floor\n" +
            "from service s join rent_type rt on s.rent_type_id = rt.rent_type_id\n" +
            "join service_type st on st.service_type_id = s.service_type_id\n" +
            "where s.service_name = ?;";

    private static final String FIND_RENT_TYPE_SQL ="select rent_type_id,rent_type_name\n" +
            "from rent_type;\n";

    private static final String FIND_SERVICE_TYPE_SQL ="select service_type_id,service_type_name\n" +
            "from service_type;";

    public static List<Service> findAll(){
        Connection connection = baseRepository.connectDataBase();
        List<Service> services = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SERVICE_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("service_id");
                String name = resultSet.getString("service_name");
                Double cost = resultSet.getDouble("service_cost");
                String rentType = resultSet.getString("rent_type_name");
                String serviceType = resultSet.getString("service_type_name");
                int maxPeople = resultSet.getInt("service_max_peple");
                Service service = new Service(id, name, cost, maxPeople,rentType,serviceType);
                services.add(service);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    public void save(Service service) {
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SERVICE_SQL);
            preparedStatement.setInt(1,service.getId());
            preparedStatement.setString(2,service.getName());
            preparedStatement.setInt(3,service.getArea());
            preparedStatement.setDouble(4,service.getCost());
            preparedStatement.setInt(5,service.getMaxPeople());
            if (service.getRentType().equals("Hour")){
                preparedStatement.setInt(6,1);
            } else if (service.getRentType().equals("Day")){
                preparedStatement.setInt(6,2);
            } else if (service.getRentType().equals("Month")){
                preparedStatement.setInt(6,3);
            }
            if (service.getServiceType().equals("VIP")){
                preparedStatement.setInt(7,1);
            } else if (service.getRentType().equals("Normal")){
                preparedStatement.setInt(7,2);
            }
            preparedStatement.setString(8,service.getStandard());
            preparedStatement.setString(9,service.getDecription());
            preparedStatement.setDouble(10,service.getPoorArea());
            preparedStatement.setInt(11,service.getNumberFloor());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Service finByName(String name) {
        Service service  = null;
        Connection connection =baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_SERVICE_BUY_NAME_SQL);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("service_id");
                String name1 = resultSet.getString("service_name");
                int area = resultSet.getInt("service_area");
                double cost = resultSet.getDouble("service_cost");
                int maxp = resultSet.getInt("service_max_peple");
                String rent = resultSet.getString("rent_type_name");
                String type = resultSet.getString("service_type_name");
                String standard = resultSet.getString("standard_rome");
                String decription = resultSet.getString("decription_other_convenient");
                double pool = resultSet.getDouble("poor_area");
                int floor = resultSet.getInt("number_of_floor");
                service = new Service(id, name1, area, cost,maxp,rent,type,standard,decription,pool,floor);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }

    public boolean update(Service service) {
        Connection connection =baseRepository.connectDataBase();
        List<String[]> rents = findNameRentType();
        List<String[]> types = findNameServiceType();
        boolean check=false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SERVICE_SQL);
            preparedStatement.setInt(1,service.getArea());
            preparedStatement.setDouble(2,service.getCost());
            preparedStatement.setInt(3,service.getMaxPeople());
            for (int i = 0; i < rents.size(); i++) {
                if (service.getRentType().equals((rents.get(i))[1])){
                    preparedStatement.setInt(4,(i+1));
                }
            }
            for (int i = 0; i < types.size(); i++) {
                if (service.getServiceType().equals((types.get(i))[1])){
                    preparedStatement.setInt(5,(i+1));
                }
            }
            preparedStatement.setString(6,service.getStandard());
            preparedStatement.setString(7,service.getDecription());
            preparedStatement.setDouble(8,service.getPoorArea());
            preparedStatement.setInt(9,service.getNumberFloor());
            preparedStatement.setString(10,service.getName());
            check =preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public List<String[]> findNameRentType() {
        Connection connection = baseRepository.connectDataBase();
        List<String[]> listRent = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_RENT_TYPE_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("rent_type_id");
                String name = resultSet.getString("rent_type_name");
                String[] string = {id,name};
                listRent.add(string);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listRent;

    }

    public List<String[]> findNameServiceType() {
        Connection connection = baseRepository.connectDataBase();
        List<String[]> listType = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_SERVICE_TYPE_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("service_type_id");
                String name = resultSet.getString("service_type_name");
                String[] string = {id,name};
                listType.add(string);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listType;
    }

//    public static void main(String[] args) {
//        System.out.println(findAll());
//    }
}
