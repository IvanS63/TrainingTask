package com.haulmont.trainingtask.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorType;
import javax.persistence.Inheritance;
import javax.persistence.DiscriminatorColumn;

@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "TRAININGTASK_CUSTOMER")
@Entity(name = "trainingtask$Customer")
public class Customer extends StandardEntity {
    private static final long serialVersionUID = -4026095172520412568L;

    @Column(name = "NAME", nullable = false, length = 100)
    protected String name;

    @Column(name = "PHONE", nullable = false, length = 100)
    protected String phone;

    @Column(name = "EMAIL", nullable = false, unique = true, length = 100)
    protected String email;


    @JoinTable(name = "TRAININGTASK_CAR_SERVICE_CENTER_CUSTOMER_LINK",
        joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
        inverseJoinColumns = @JoinColumn(name = "CAR_SERVICE_CENTER_ID"))
    @ManyToMany
    protected Set<CarServiceCenter> carServiceCenters;

    public void setCarServiceCenters(Set<CarServiceCenter> carServiceCenters) {
        this.carServiceCenters = carServiceCenters;
    }

    public Set<CarServiceCenter> getCarServiceCenters() {
        return carServiceCenters;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


}