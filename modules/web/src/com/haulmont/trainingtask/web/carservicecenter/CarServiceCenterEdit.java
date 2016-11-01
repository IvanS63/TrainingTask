package com.haulmont.trainingtask.web.carservicecenter;

import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.WindowParams;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.TabSheet;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.trainingtask.entity.CarServiceCenter;
import com.haulmont.trainingtask.entity.Customer;
import com.haulmont.trainingtask.entity.Employee;
import com.haulmont.trainingtask.service.CityService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;
import java.util.UUID;

public class CarServiceCenterEdit extends AbstractEditor<CarServiceCenter> {

    @Inject
    private UserSessionSource userSessionSource;

    @Inject
    protected Messages messages;

    @Inject
    private CityService cityService;

    @Inject
    private Table customersTable;

    @Named("tabSheet")
    private TabSheet tabSheet;

    @Inject
    private CollectionDatasource<Customer, UUID> customersDs;

    @Override
    public void init(Map<String, Object> params) {
        setItem(WindowParams.ITEM.getEntity(params));
        initDefaultCity();
        setCustomersTableParams();
        setCustomersListener();
    }

    /**
     * Set city as default
     */
    private void initDefaultCity() {
        getItem().setCity(cityService.getDefaultCity());
        getItem().setCreatedByUser(userSessionSource.getUserSession().getUser());
    }

    /**
     * Customize customer table by adding customer type
     */
    @SuppressWarnings("unchecked")
    private void setCustomersTableParams() {
        customersTable.addGeneratedColumn(getMessage("customerType"), entity ->
                new Table.PlainTextCell(messages.getMessage("com.haulmont.trainingtask.entity.messages.properties",
                        entity.getClass().getSimpleName())));
    }

    /**
     * Update customer tab with count of customers
     */
    private void setCustomersListener() {
        customersDs.addCollectionChangeListener(e ->
                tabSheet.getTab("customersTab")
                        .setCaption(getMessage("customersTab") + " (" + customersDs.size() + ")"));
    }

}