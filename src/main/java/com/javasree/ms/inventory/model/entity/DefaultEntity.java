package com.javasree.ms.inventory.model.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class DefaultEntity extends IDEntity{

    @Column(columnDefinition = "tinyint(1) default 0",nullable = false)
    private boolean status;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name="createdOn")
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name="updatedOn")
    private Date updatedOn;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
}
