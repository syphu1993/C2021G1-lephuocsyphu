package service.model.services.impl;

import service.model.bean.Service;
import service.model.repository.ServiceRepository;
import service.model.services.IService;

import java.util.List;

public class ServiceImpl implements IService {
    ServiceRepository serviceRepository = new ServiceRepository();
    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public Service finByName(String name) {
        return serviceRepository.finByName(name);
    }

    @Override
    public boolean update(Service service) {
        return serviceRepository.update(service);
    }

    @Override
    public List<String[]> findNameRentType() {
        return serviceRepository.findNameRentType();
    }

    @Override
    public List<String[]> findNameServiceType() {
        return serviceRepository.findNameServiceType();
    }
}
