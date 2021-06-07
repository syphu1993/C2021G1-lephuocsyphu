package contract.model.service.Impl;

import contract.model.bean.Contract;
import contract.model.bean.ContractDetail;
import contract.model.bean.ContractUseAttachService;
import contract.model.repository.ContractRepository;
import contract.model.service.IContract;
import customer.model.bean.Customer;
import employee.model.bean.Employee;
import service.model.bean.Service;

import java.util.List;

public class ContractImpl implements IContract {
    ContractRepository contractRepository = new ContractRepository();
    @Override
    public  List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<Employee> findEmployee() {
        return contractRepository.findEmployee();
    }

    @Override
    public List<Customer> findCustomer() {
        return contractRepository.findCustomer();
    }

    @Override
    public List<Service> findService() {
        return contractRepository.findService();
    }

    @Override
    public Contract findContractByID(int id) {
        return contractRepository.findContractByID(id);
    }

    @Override
    public List<String[]> findAttachService() {
        return contractRepository.findAttachService();
    }

    @Override
    public void creatContractDetail(ContractDetail contractDetail) {
        contractRepository.creatContractDetail(contractDetail);
    }

    @Override
    public List<ContractUseAttachService> findAllCustomerUseService() {
        return contractRepository.findAllCustomerUseService();
    }

    @Override
    public boolean delete(int id) {
        return contractRepository.delete(id);
    }

}
