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
}
