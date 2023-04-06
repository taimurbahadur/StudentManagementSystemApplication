package com.intellicode.studentmanagementsystemapplication.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {


    @Serial
    private static final long serialVersionUID = 671453595895902185L;

    @CreationTimestamp
    @Column(name = "CREATED_DATE")
    protected Date createdDate;

    @UpdateTimestamp
    @Column(name = "UPDATED_DATE")
    protected Date updatedDate;

    @Column(name = "IS_DELETED", columnDefinition = "tinyint(0) DEFAULT 0")
    protected Boolean isDeleted;

    @Column(name = "UPDATED_BY", columnDefinition = "int(11) DEFAULT 0")
    protected Integer updatedBy;

    @Column(name = "CREATED_BY", columnDefinition = "int(11) DEFAULT 0")
    protected Integer createdBy;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public BaseEntity(Date createdDate, Date updatedDate, Boolean isDeleted, Integer updatedBy, Integer createdBy) {
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.isDeleted = isDeleted;
        this.updatedBy = updatedBy;
        this.createdBy = createdBy;
    }

    public BaseEntity() {
    }
}
