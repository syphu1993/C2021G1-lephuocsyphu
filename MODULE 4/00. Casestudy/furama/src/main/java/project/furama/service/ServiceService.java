package project.furama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.furama.repository.ServiceRepository;

@Service
public class ServiceService implements IServiceService {
    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public Iterable<project.furama.model.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(project.furama.model.Service service) {
        serviceRepository.save(service);
    }
}
