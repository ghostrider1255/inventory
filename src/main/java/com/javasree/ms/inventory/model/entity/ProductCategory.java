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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
