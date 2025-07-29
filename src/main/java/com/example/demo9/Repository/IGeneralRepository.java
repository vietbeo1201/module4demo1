package com.example.demo9.Repository;

import java.util.List;

public interface IGeneralRepository<T> {
    List<T> findAll();

    T findById(Integer id);

    void save(T t);

    void remove(Integer id);
}
