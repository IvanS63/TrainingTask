package com.haulmont.trainingtask.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.Composition;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.security.entity.User;

@NamePattern("%s|name")
@Table(name = "TRAININGTASK_CAR_SERVICE_CENTER")
@Entity(name = "trainingtask$CarServiceCenter")
public class CarServiceCenter extends StandardEntity {
    private static final long serialVersionUID = -7669595936885923707L;

    @Column(name = "NAME", nullable = false, length = 100)
    protected String name;

    @Column(name = "PHONE", nullable = false, length = 100)
    protected String phone;

    @Column(name = "ADDRESS", nullable = false)
    protected String address;

    @OnDeleteInverse(DeletePolicy.DENY)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CITY_ID")
    protected City city;

    @Composition
    @OnDelete(DeletePolicy.DENY)
    @OneToMany(mappedBy = "center")
    protected Set<Repair> repair;

    @OnDelete(DeletePolicy.DENY)
    @OneToMany(mappedBy = "center")
    protected Set<Employee> employees;

    @JoinTable(name = "TRAININGTASK_CAR_SERVICE_CENTER_CUSTOMER_LINK",
        joinColumns = @JoinColumn(name = "CAR_SERVICE_CENTER_ID"),
        inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID"))
    @ManyToMany
    protected Set<Customer> customers;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CREATED_BY_USER_ID")
    protected User createdByUser;

    public void setCreatedByUser(User createdByUser) {
        this.createdByUser = createdByUser;
    }

    public User getCreatedByUser() {
        return createdByUser;
    }


    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }


    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }



    public void setRepair(Set<Repair> repair) {
        this.repair = repair;
    }

    public Set<Repair> getRepair() {
        return repair;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }


}