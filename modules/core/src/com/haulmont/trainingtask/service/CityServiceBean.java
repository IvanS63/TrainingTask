package com.haulmont.trainingtask.service;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.trainingtask.entity.City;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import java.util.List;

@Service(CityService.NAME)
public class CityServiceBean implements CityService {

    @Inject
    private Persistence persistence;

    @Transactional
    @Override
    public City getDefaultCity() {
        try {
            return persistence.getEntityManager()
                    .createQuery("select c from trainingtask$City c where c.defaultCity=true", City.class)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Transactional
    @Override
    public void resetDefaultCity(City city) {
        persistence.getEntityManager()
                .createQuery("update trainingtask$City c set c.defaultCity=false where c.id!=:value")
                .setParameter("value", city.getId()).executeUpdate();
    }

    @Transactional
    @Override
    public void setRandomDefaultCity() {
        persistence.getEntityManager()
                .createNativeQuery("update trainingtask_city set default_city=true where id in (select id from trainingtask_city limit 1)");
    }


}