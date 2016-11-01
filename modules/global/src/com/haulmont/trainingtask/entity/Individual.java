package com.haulmont.trainingtask.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@Table(name = "TRAININGTASK_INDIVIDUAL")
@Entity(name = "trainingtask$Individual")
public class Individual extends Customer {
    private static final long serialVersionUID = -2007762525348644654L;

    @Column(name = "PASSPORT_NO", nullable = false, length = 100)
    protected String passportNo;

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }



}