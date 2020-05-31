package com.javasree.ms.inventory.service;

import com.javasree.ms.inventory.model.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();

    ProductDto findByName(String name);

}
