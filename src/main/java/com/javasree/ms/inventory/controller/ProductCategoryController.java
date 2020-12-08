package com.javasree.ms.inventory.controller;


import com.javasree.ms.inventory.model.dto.ProductCategoryDto;
import com.javasree.ms.inventory.service.ProductCategoryService;
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
@RequestMapping("/category")
public class ProductCategoryController extends StatusCheckController{

    private Logger logger = LoggerFactory.getLogger(ProductCategoryController.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductCategoryDto> createCategory(@Valid @RequestBody ProductCategoryDto productCategoryDto){
        ProductCategoryDto savedProductCategoryDto = productCategoryService.createCategory(productCategoryDto);
        logger.info("new Product Category Object got created");
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProductCategoryDto);
    }

    @GetMapping(path = "/",produces = "application/json")
    public ResponseEntity<List<ProductCategoryDto>> getAllCategories(){
        List<ProductCategoryDto> categories = productCategoryService.findAllCategories();
        logger.info("returning a list of categories of size:"+categories.size());
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }
}
