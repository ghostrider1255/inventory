package com.javasree.ms.inventory.controller;

import com.javasree.ms.inventory.model.dto.ProductDto;
import com.javasree.ms.inventory.service.ProductService;
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
@RequestMapping("/products")
public class ProductController extends StatusCheckController{
    private Logger logger = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductService productService;

    /*@GetMapping(path="/check-api", produces = "application/json")
    public String status(){
        return "Products service API is working fine:";
    }*/

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto){
        ProductDto savedProductDto = productService.createProduct(productDto);
        logger.info("new Product Object got created:"+savedProductDto.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProductDto);
    }

    @GetMapping(path = "/",produces = "application/json")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> products = productService.findAll();
        logger.info("returning a list of products of size:"+products.size());
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
