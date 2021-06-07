package service.model.services;

import customer.model.bean.Customer;
import service.model.bean.Service;

import java.util.List;

public interface IService {
    List<Service> findAll();
    void save(Service service);
    Service finByName(String name);
    boolean update(Service service);
    List<String[]> findNameRentType();
    List<String[]> findNameServiceType();
}
