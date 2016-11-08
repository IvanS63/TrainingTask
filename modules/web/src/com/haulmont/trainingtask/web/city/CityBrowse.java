package com.haulmont.trainingtask.web.city;

import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.components.actions.EditAction;
import com.haulmont.cuba.gui.components.actions.RemoveAction;
import com.haulmont.trainingtask.service.CityService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

public class CityBrowse extends AbstractLookup {

    @Inject
    private CityService cityService;

    @Named("citiesTable")
    private Table cityTable;

    @Named("citiesTable.edit")
    private EditAction citiesTableEdit;

    @Named("citiesTable.create")
    private CreateAction citiesTableCreate;

    @Named("citiesTable.remove")
    private RemoveAction citiesRemoveAction;

    public void init(Map<String, Object> params) {
        super.init(params);
        initAfterCommitTableRefreshing();

    }

    private void initAfterCommitTableRefreshing() {
        citiesTableCreate.setAfterCommitHandler(entity -> cityTable.refresh());
        citiesTableEdit.setAfterCommitHandler(entity -> cityTable.refresh());
        citiesRemoveAction.setAfterRemoveHandler(entity -> {
            if (cityService.getDefaultCity() == null) {
                cityService.setRandomDefaultCity();
                cityTable.refresh();
            }
        });
    }


}