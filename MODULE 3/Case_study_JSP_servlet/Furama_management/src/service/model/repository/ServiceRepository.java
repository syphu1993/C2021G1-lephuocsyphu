package service.model.repository;

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
            } else if (service.getRentType().equals("Day")){
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

//    public static void main(String[] args) {
//        System.out.println(findAll());
//    }
}
