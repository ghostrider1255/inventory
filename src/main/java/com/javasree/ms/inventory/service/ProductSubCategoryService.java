package com.javasree.ms.inventory.service;

import com.javasree.ms.inventory.model.dto.ProductSubCategoryDto;

import java.util.List;

public interface ProductSubCategoryService {

    List<ProductSubCategoryDto> findAllSubCategories();

    ProductSubCategoryDto findSubCategoryByName(String subCategoryName);

    ProductSubCategoryDto createSubCategory(ProductSubCategoryDto productSubCategoryDto);

}
