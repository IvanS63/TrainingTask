package com.haulmont.trainingtask.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@Table(name = "TRAININGTASK_COMPANY")
@Entity(name = "trainingtask$Company")
public class Company extends Customer {
    private static final long serialVersionUID = 8026690417582485247L;

    @Column(name = "INN", nullable = false, length = 100)
    protected String inn;

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }



}