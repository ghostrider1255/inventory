package com.javasree.ms.inventory.controller;

import com.javasree.ms.inventory.model.dto.BrandDto;
import com.javasree.ms.inventory.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController extends StatusCheckController{

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BrandService brandService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BrandDto> createBrand(@Valid @RequestBody BrandDto brandDto){
        BrandDto savedBrandDto = brandService.crateBrand(brandDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBrandDto);
    }

    @GetMapping(path = "/",produces = "application/json")
    public ResponseEntity<List<BrandDto>> getAll(){
        List<BrandDto> brands = brandService.findAllBrands();
        return ResponseEntity.status(HttpStatus.OK).body(brands);
    }
}
