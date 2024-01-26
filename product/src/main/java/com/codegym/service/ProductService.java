package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService implements IProductService<Product> {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void save(Product product) {
      productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
      productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }


    @Override
    public List<Product> findByNameProduct(String name) {
        return productRepository.findAllByNameContaining(name);
    }


}
