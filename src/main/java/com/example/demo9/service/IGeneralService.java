package com.example.demo9.service;

import java.util.List;

public interface IGeneralService<E> {
    List<E> findAll();

    void save(E e);

    E findById(Integer id);

    void remove(Integer id);
}
