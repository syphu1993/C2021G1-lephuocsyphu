package com.codegym.managerprovince.service;

import com.codegym.managerprovince.exception.CustomerException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGeneralService<T> {
    Page<T> findAll(Pageable pageable);

    Optional<T> findById(Long id);

    void save(T t) throws CustomerException;

    void remove(Long id);

    Page<T> findAllByName(Pageable pageable,String key);
}