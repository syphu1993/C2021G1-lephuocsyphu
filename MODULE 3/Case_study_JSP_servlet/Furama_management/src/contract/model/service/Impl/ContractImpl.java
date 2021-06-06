package contract.model.service.Impl;

import contract.model.service.IContract;
import customer.model.bean.Customer;
import employee.model.bean.Employee;
import contract.model.bean.Contract;
import service.model.bean.Service;

import java.util.List;

public class ContractImpl implements IContract {

    @Override
    public List<Contract> findAll() {
        return null;
    }

    @Override
    public void save(Contract contract) {

    }

    @Override
    public List<Employee> findEmployee() {
        return null;
    }

    @Override
    public List<Customer> findCustomer() {
        return null;
    }

    @Override
    public List<Service> findService() {
        return null;
    }
}
