package com.example.btproductmanagement.dao;

import com.example.btproductmanagement.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDAO implements IProductDAO{
    private static final Map<Integer,Product> products;

    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"Táo tàu",100,25));
        products.put(2,new Product(2,"Cam",120,10));
        products.put(3,new Product(3,"Dưa",80,15));
        products.put(4,new Product(4,"Chanh",50,40));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remote(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products1 = new ArrayList<>();
        List<Product> products2  = findAll();
        for (int i = 0; i < products2.size(); i++) {
            if (products2.get(i).getName().equalsIgnoreCase(name)){
                products1.add(products2.get(i));
            }
        }
        return products1;
    }
}
