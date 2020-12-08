package com.javasree.ms.inventory.controller;

import com.javasree.ms.inventory.model.dto.BrandDto;
import com.javasree.ms.inventory.service.BrandService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BrandService brandService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BrandDto> createBrand(@Valid @RequestBody BrandDto brandDto){
        logger.debug("received Brand object in the request as: "+brandDto.toString());
        BrandDto savedBrandDto = brandService.crateBrand(brandDto);
        logger.info("new Brand Object got created");
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBrandDto);
    }

    @GetMapping(path = "/",produces = "application/json")
    public ResponseEntity<List<BrandDto>> getAll(){
        List<BrandDto> brands = brandService.findAllBrands();
        logger.info("returning a list of brands of size:"+brands.size());
        return ResponseEntity.status(HttpStatus.OK).body(brands);
    }
}
