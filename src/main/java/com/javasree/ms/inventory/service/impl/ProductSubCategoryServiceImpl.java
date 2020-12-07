package com.javasree.ms.inventory.service.impl;

import com.javasree.ms.inventory.model.dto.ProductSubCategoryDto;
import com.javasree.ms.inventory.model.entity.ProductSubCategory;
import com.javasree.ms.inventory.repository.ProductSubCategoryRepo;
import com.javasree.ms.inventory.service.ProductSubCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductSubCategoryServiceImpl implements ProductSubCategoryService {

    @Autowired
    private ProductSubCategoryRepo subCategoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductSubCategoryDto> findAllSubCategories() {
        List<ProductSubCategory> productSubCategories= subCategoryRepo.findAll();
        return productSubCategories.stream().map( productSubCategory ->
                this.modelMapper.map(productSubCategory,ProductSubCategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductSubCategoryDto findSubCategoryByName(String categoryName) {
        ProductSubCategory category = this.subCategoryRepo.findBySubCategoryName(categoryName);
        return this.modelMapper.map(category,ProductSubCategoryDto.class);
    }

    @Override
    public ProductSubCategoryDto createSubCategory(ProductSubCategoryDto productSubCategoryDto) {
        ProductSubCategory productSubCategory = this.modelMapper.map(productSubCategoryDto,ProductSubCategory.class);
        this.subCategoryRepo.save(productSubCategory);
        return productSubCategoryDto;
    }
}
