package com.javasree.ms.inventory.service.impl;

import com.javasree.ms.inventory.model.dto.BrandDto;
import com.javasree.ms.inventory.model.entity.Brand;
import com.javasree.ms.inventory.repository.BrandRepo;
import com.javasree.ms.inventory.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepo brandRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BrandDto> findAllBrands() {
        List<Brand> brands = brandRepo.findAll();
        List<BrandDto> brandsDto = brands.stream().map( brand -> this.modelMapper.map(brand,BrandDto.class))
                .collect(Collectors.toList());
        return brandsDto;
    }

    @Override
    public BrandDto findBrandByName(String name) {
        return this.modelMapper.map(brandRepo.findByName(name),BrandDto.class);
    }

    @Override
    public BrandDto findBrandByCode(String code) {
        return this.modelMapper.map(brandRepo.findByCode(code),BrandDto.class);
    }
}
