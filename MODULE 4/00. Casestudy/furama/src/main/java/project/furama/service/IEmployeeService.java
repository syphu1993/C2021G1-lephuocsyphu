package project.furama.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project.furama.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Optional<Employee> findById(Integer id);

    void save(Employee employee);

    void remove(Integer id);

    Page<Employee> findAllByName(Pageable pageable,String key);

    Iterable<Employee> findAllNoPage();
}
