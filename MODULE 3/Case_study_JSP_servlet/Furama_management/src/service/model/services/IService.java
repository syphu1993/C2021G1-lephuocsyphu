package service.model.services;

import service.model.bean.Service;

import java.util.List;

public interface IService {
    List<Service> findAll();
    void save(Service service);
}
