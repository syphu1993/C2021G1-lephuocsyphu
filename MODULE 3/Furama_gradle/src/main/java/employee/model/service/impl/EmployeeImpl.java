package employee.model.service.impl;

import employee.model.bean.Employee;
import employee.model.repository.EmployeeRepository;
import employee.model.service.IEmployee;

import java.util.List;

public class EmployeeImpl implements IEmployee {
    EmployeeRepository employeeRepository=new EmployeeRepository();
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public boolean update(Employee employee) {
        return employeeRepository.update(employee);
    }

    @Override
    public boolean delete(int id) {
        return employeeRepository.delete(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<String> findNamePosition() {
        return employeeRepository.findNamePosition();
    }

    @Override
    public List<String> findNameDegree() {
        return employeeRepository.findNameDegree();
    }

    @Override
    public List<String> findNameDivision() {
        return employeeRepository.findNameDivision();
    }
}
