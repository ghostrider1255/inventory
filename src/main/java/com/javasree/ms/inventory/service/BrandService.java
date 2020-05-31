package com.javasree.ms.inventory.service;

import com.javasree.ms.inventory.model.dto.BrandDto;

import java.util.List;

public interface BrandService {

    List<BrandDto> findAllBrands();

    BrandDto findBrandByName(String name);

    BrandDto findBrandByCode(String code);
}
