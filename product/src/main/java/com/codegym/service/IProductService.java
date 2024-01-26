package com.codegym.service;

import java.util.List;
import java.util.Optional;

public interface IProductService<E> {
    void save(E e);
    void delete(Long id);
    List<E> findAll();
    Optional<E> findById(Long id);
    List<E> findByNameProduct(String name);

}
