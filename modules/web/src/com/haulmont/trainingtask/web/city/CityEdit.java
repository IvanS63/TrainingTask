package com.haulmont.trainingtask.web.city;

import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.Field;
import com.haulmont.trainingtask.entity.City;
import com.haulmont.trainingtask.service.CityService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

public class CityEdit extends AbstractEditor<City> {

    @Inject
    private DataManager dataManager;

    @Named("fieldGroup.defaultCity")
    private Field field;

    @Inject
    private CityService cityService;

    /**
     * Reset all other cities default value to false
     *
     * @param commited
     * @param close
     * @return
     */
    @Override
    protected boolean postCommit(boolean commited, boolean close) {
        if (commited) {
            if (field.getValue()) {
                //cityService.resetDefaultCity(getItem());
                resetAllDefaultCities();
            }
        }
        return super.postCommit(commited, close);
    }

    /**
     * Reset all other cities to default using DataManager
     */
    private void resetAllDefaultCities() {
        List<City> list = loadCities();
        for (City c : list) {
            c.setDefaultCity(false);
        }
        CommitContext commitContext = new CommitContext(list);
        dataManager.commit(commitContext);

    }

    /**
     * Get other cities
     *
     * @return List of Cities except for current edited city
     */
    @SuppressWarnings("unchecked")
    private List<City> loadCities() {
        LoadContext loadContext = LoadContext.create(City.class)
                .setQuery(LoadContext.createQuery("select c from trainingtask$City c where c.id != :value")
                        .setParameter("value", getItem().getId()));
        return dataManager.loadList(loadContext);
    }


}