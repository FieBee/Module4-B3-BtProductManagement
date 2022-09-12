package com.example.btproductmanagement.dao;

import com.example.btproductmanagement.model.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    List<Product> findByName(String name);
    void update(int id, Product product);
    void remote(int it);
}
