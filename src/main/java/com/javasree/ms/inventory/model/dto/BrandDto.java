package com.javasree.ms.inventory.model.dto;

public class BrandDto {

    private String name;
    private String code;
    private String description;

    public BrandDto(){}
    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
