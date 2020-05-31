package com.javasree.ms.inventory.controller;

import com.javasree.ms.inventory.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BrandService brandService;

    @GetMapping(path="/check-api", produces = "application/json")
    public String status(){
        return "Brand service API is working fine:";
    }
}
