package com.company.character_file.service;

import com.company.character_file.model.Student;

import java.util.List;

public interface IPersonService<E> {
    boolean add(E e);
    boolean edit(E e, int index);
    boolean delete(int index);
    List<E> list();
    E inputAddOrEdit();
}
