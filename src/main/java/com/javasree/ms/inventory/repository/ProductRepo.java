package com.javasree.ms.inventory.repository;

import com.javasree.ms.inventory.model.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product,Long> {

    List<Product> findAll();

    Product findByName(String name);
}
