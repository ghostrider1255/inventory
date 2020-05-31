package com.javasree.ms.inventory.service.impl;

import com.javasree.ms.inventory.model.dto.ProductCategoryDto;
import com.javasree.ms.inventory.model.entity.ProductCategory;
import com.javasree.ms.inventory.repository.ProductCategoryRepo;
import com.javasree.ms.inventory.service.ProductCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<ProductCategoryDto> findAllCategories() {
        List<ProductCategory> productCategories= categoryRepo.findAll();
        return productCategories.stream().map( productCategory ->
                this.modelMapper.map(productCategory,ProductCategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductCategoryDto findCategoryByName(String categoryName) {
        ProductCategory category = this.categoryRepo.findByCategoryname(categoryName);
        return this.modelMapper.map(category,ProductCategoryDto.class);
    }
}
