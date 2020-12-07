package com.javasree.ms.inventory.model.entity;

import javax.persistence.*;

@Entity
@Table(name="ProductCategory")
public class ProductCategory extends DefaultEntity{

    @Column(name="CategoryName", nullable = false, length = 50)
    private String categoryName;

    @Column(name="description", nullable = false, length = 100)
    private String description;

    @Column(name="code", nullable = false, length = 15)
    private String code;

    public ProductCategory(){}

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
