package com.javasree.ms.inventory.model.dto;

import java.util.Set;

public class ProductDto {

    private String name;
    private BrandDto brand;
    private Set<ProductCategoryDto> categories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BrandDto getBrand() {
        return brand;
    }

    public void setBrand(BrandDto brand) {
        this.brand = brand;
    }

    public Set<ProductCategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(Set<ProductCategoryDto> categories) {
        this.categories = categories;
    }
}
