package com.javasree.ms.inventory.repository;

import com.javasree.ms.inventory.model.dto.BrandDto;
import com.javasree.ms.inventory.model.entity.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrandRepo extends CrudRepository<Brand,Long> {

    List<Brand> findAll();

    Brand findByName();

    Brand findByCode();
}
