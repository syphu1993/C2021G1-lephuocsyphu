package mamagement_student.model.service.impl;

import mamagement_student.model.bean.Student;
import mamagement_student.model.repository.StudentRepository;
import mamagement_student.model.service.IStudent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentImpl implements IStudent {
    StudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public Map<String, String> save(Student student) {
        boolean flag = true;
        Map<String,String> mapMesg = new HashMap<>();
        if ("".equals(student.getName())){
            mapMesg.put("name","Input name, please!");
            flag = false;
        } else if (!student.getName().matches("^[a-zA-Z]+(?: [a-zA-Z]+)+$")){
            mapMesg.put("name","Is not format");
            flag = false;
        }
        if (flag){
            studentRepository.save(student);
        }
        return mapMesg;
    }

    @Override
    public boolean update(Student student) {
        return studentRepository.update(student);
    }

    @Override
    public boolean delete(int id) {
        return studentRepository.delete(id);
    }

    @Override
    public List<Student> findByName(String name) {
        return null;
    }
}
