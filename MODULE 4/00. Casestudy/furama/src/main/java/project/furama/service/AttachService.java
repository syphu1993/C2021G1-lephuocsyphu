package project.furama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.furama.repository.AttachServiceRepository;

@Service
public class AttachService implements IAttachService{
    @Autowired
    AttachServiceRepository attachServiceRepository;
    @Override
    public Iterable<project.furama.model.AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
