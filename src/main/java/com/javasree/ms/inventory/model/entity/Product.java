package com.javasree.ms.inventory.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Product")
public class Product extends DefaultEntity{

    @Column(name="name", nullable = false, length = 50)
    private String name;
    @OneToOne
    @JoinColumn(name = "brandId", referencedColumnName = "id")
    private Brand brand;
    @OneToMany
    private Set<ProductCategory> categories;

    public Product(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Set<ProductCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<ProductCategory> categories) {
        this.categories = categories;
    }
}
