package com.javasree.ms.inventory.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Brand")
public class Brand extends DefaultEntity{

    @Column(name="name", nullable = false, length = 150)
    private String name;

    @Column(name="description", nullable = false, length = 150)
    private String description;

    @Column(name="code", nullable = false, length = 20)
    private String code;

    public Brand(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
