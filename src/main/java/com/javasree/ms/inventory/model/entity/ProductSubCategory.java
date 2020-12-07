package com.javasree.ms.inventory.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ProductSubCategory")
public class ProductSubCategory extends DefaultEntity{

    @Column(name="SubCategoryName", nullable = false, length = 50)
    private String subCategoryName;

    @Column(name="description", nullable = false, length = 100)
    private String description;

    @Column(name="SubCategoryCode", nullable = false, length = 15)
    private String subCategoryCode;

    public ProductSubCategory(){}

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubCategoryCode() {
        return subCategoryCode;
    }

    public void setSubCategoryCode(String subCategoryCode) {
        this.subCategoryCode = subCategoryCode;
    }
}
