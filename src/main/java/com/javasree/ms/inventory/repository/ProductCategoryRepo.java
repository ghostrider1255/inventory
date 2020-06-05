package com.javasree.ms.inventory.repository;

import com.javasree.ms.inventory.model.entity.ProductCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCategoryRepo extends CrudRepository<ProductCategory,Long> {

    List<ProductCategory> findAll();

    ProductCategory findByCategoryName(String categoryName);

    ProductCategory findByCode(String code);
}
