package mamagement_student.model.service;

import mamagement_student.model.bean.Student;

import java.util.List;
import java.util.Map;

public interface IStudent {
    List<Student> findAll();
    Student findById(int id);
    Map<String,String> save(Student student);
    Map<String,String> update(Student student);
    boolean delete(int id);
    List<Student> findByName(String name);
}
