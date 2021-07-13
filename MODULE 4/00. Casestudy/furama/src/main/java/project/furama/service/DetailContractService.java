package project.furama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.furama.model.DetailContract;
import project.furama.repository.DetailContractRepository;

@Service
public class DetailContractService implements IDetailContracService {
    @Autowired
    private DetailContractRepository detailContractRepository;
    @Override
    public void save(DetailContract detailContract) {
        detailContractRepository.save(detailContract);
    }
}
