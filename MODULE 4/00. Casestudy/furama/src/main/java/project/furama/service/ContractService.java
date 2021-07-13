package project.furama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.furama.model.Contract;
import project.furama.repository.ContractRepository;

@Service
public class ContractService implements IContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Page<Contract> findAllByPage(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Iterable<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }
}
