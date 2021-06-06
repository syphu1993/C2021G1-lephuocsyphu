package employee.model.service;

import employee.model.bean.Employee;

import java.util.List;

public interface IEmployee {
    List<Employee> findAll();
    Employee findById(int id);
    void save(Employee employee);
    boolean update(Employee employee);
    boolean delete(int id);
    List<Employee> findByName(String name);
    List<String> findNamePosition();
    List<String> findNameDegree();
    List<String> findNameDivision();
}
