package com.javasree.ms.inventory.service;

import com.javasree.ms.inventory.model.dto.ProductCategoryDto;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategoryDto> findAllCategories();

    ProductCategoryDto findCategoryByName(String categoryName);

}
