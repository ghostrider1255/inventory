package com.javasree.ms.inventory.service.impl;

import com.javasree.ms.inventory.model.dto.ProductDto;
import com.javasree.ms.inventory.model.entity.Product;
import com.javasree.ms.inventory.repository.ProductRepo;
import com.javasree.ms.inventory.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductDto> findAll() {
        List<Product> products = this.productRepo.findAll();
        return products.stream().map( product ->
                this.modelMapper.map(product,ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findByName(String name) {
        Product product = this.productRepo.findByName();
        return this.modelMapper.map(product,ProductDto.class);
    }
}
