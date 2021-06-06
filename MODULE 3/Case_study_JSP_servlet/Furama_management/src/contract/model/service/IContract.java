package contract.model.service;

import contract.model.bean.ContractDetail;
import customer.model.bean.Customer;
import employee.model.bean.Employee;
import contract.model.bean.Contract;
import service.model.bean.Service;

import java.util.List;

public interface IContract {
    List<Contract> findAll();
    void save(Contract contract);
    List<Employee> findEmployee();
    List<Customer> findCustomer();
    List<Service> findService();
    Contract findContractByID(int id);
    List<String[]> findAttachService();
    void creatContractDetail(ContractDetail contractDetail);
}
