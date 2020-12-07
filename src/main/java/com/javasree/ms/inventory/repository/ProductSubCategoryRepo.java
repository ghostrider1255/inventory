package com.javasree.ms.inventory.repository;

import com.javasree.ms.inventory.model.entity.ProductSubCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductSubCategoryRepo extends CrudRepository<ProductSubCategory,Long> {

    List<ProductSubCategory> findAll();

    ProductSubCategory findBySubCategoryName(String categoryName);

    ProductSubCategory findBySubCategoryCode(String code);
}
