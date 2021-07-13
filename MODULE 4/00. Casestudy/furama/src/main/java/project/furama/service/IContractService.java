package project.furama.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project.furama.model.Contract;

public interface IContractService {
    Page<Contract> findAllByPage(Pageable pageable);
    Iterable<Contract> findAll();
    void save(Contract contract);
}
