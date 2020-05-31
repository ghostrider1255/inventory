package com.javasree.ms.inventory.controller;

import com.javasree.ms.inventory.service.ProductCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class ProductCategoryController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping(path="/check-api", produces = "application/json")
    public String status(){
        return "product category API is working fine:";
    }


}
