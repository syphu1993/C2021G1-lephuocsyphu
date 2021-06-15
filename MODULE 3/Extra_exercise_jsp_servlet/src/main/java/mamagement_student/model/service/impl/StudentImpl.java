package mamagement_student.model.service.impl;

import mamagement_student.model.bean.Student;
import mamagement_student.model.repository.StudentRepository;
import mamagement_student.model.service.IStudent;

import java.util.*;

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
        int year = 0;
        String birthday = student.getBirthday();
        String[] arrayBirth =birthday.split("-");
        year= Integer.parseInt(arrayBirth[0]);
        int year2 = Calendar.getInstance().get(Calendar.YEAR);
        if (year2-year<18){
            mapMesg.put("year","Not enough year old!");
            flag = false;
        }
        if (flag){
            studentRepository.save(student);
        }
        return mapMesg;
    }

    @Override
    public Map<String,String> update(Student student) {
        boolean flag = true;
        Map<String,String> mapMesg = new HashMap<>();
        if ("".equals(student.getName())){
            mapMesg.put("name","Input name, please!");
            flag = false;
        } else if (!student.getName().matches("^[a-zA-Z]+(?: [a-zA-Z]+)+$")){
            mapMesg.put("name","Is not format");
            flag = false;
        }
        int year = 0;
        String birthday = student.getBirthday();
        String[] arrayBirth =birthday.split("-");
        year= Integer.parseInt(arrayBirth[0]);
        int year2 = Calendar.getInstance().get(Calendar.YEAR);
        if (year2-year<18){
            mapMesg.put("year","Not enough year old!");
            flag = false;
        }
        if (flag){
            studentRepository.update(student);
        }
        return mapMesg;
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
