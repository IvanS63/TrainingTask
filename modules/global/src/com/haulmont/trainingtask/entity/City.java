package com.haulmont.trainingtask.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.UniqueConstraint;

@NamePattern("%s|name")
@Table(name = "TRAININGTASK_CITY", uniqueConstraints = {
    @UniqueConstraint(name = "IDX_TRAININGTASK_CITY_UNQ", columnNames = {"NAME"})
})
@Entity(name = "trainingtask$City")
public class City extends StandardEntity {
    private static final long serialVersionUID = 6786597744762842715L;

    @Column(name = "NAME", nullable = false, unique = true, length = 100)
    protected String name;

    @Column(name = "CODE", nullable = false)
    protected Integer code;

    @Column(name = "DEFAULT_CITY", nullable = false)
    protected Boolean defaultCity = false;

    public void setDefaultCity(Boolean defaultCity) {
        this.defaultCity = defaultCity;
    }

    public Boolean getDefaultCity() {
        return defaultCity;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }


}