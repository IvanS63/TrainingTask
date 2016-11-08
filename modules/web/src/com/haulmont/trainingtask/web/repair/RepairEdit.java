package com.haulmont.trainingtask.web.repair;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.FieldGroup;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.trainingtask.entity.CarServiceCenter;
import com.haulmont.trainingtask.entity.Employee;
import com.haulmont.trainingtask.entity.Repair;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class RepairEdit extends AbstractEditor<Repair> {
    @Inject
    Datasource<Repair> repairDs;

    @Inject
    private CollectionDatasource<Employee, UUID> employeesDs;

    @Inject
    private FieldGroup fieldGroup;

    @Inject
    private DataManager dataManager;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        clearDefaultValues();
        initEmployeesSelectParams();
    }


    private void clearDefaultValues() {
        fieldGroup.getFieldComponent("employee").setEnabled(false);
    }

    /**
     * Add listener for changing employees according to CarServiceCenter
     */
    private void initEmployeesSelectParams() {
        repairDs.addItemPropertyChangeListener(e -> {
            if (e.getValue() instanceof CarServiceCenter) {
                fieldGroup.getFieldComponent("employee").setEnabled(true);
                filterEmployeesByCenter(e.getItem().getCenter());
            }
        });

    }

    /**
     * Filter employees according to selected CarServiceCenter
     *
     * @param center to search employees work in
     */
    private void filterEmployeesByCenter(CarServiceCenter center) {
        if (center != null) {
            employeesDs.clear();
            for (Employee e : loadEmployees(center)) {
                employeesDs.addItem(e);
            }
            fieldGroup.getField("employee").setDatasource(employeesDs);
            fieldGroup.setFieldValue("employee", null);
        }
    }

    /**
     * Load current CarServiceCenter employees
     *
     * @param center search param
     * @return filtered employees
     */
    @SuppressWarnings("unchecked")
    private List<Employee> loadEmployees(CarServiceCenter center) {
        LoadContext loadContext = LoadContext.create(Employee.class)
                .setQuery(LoadContext.createQuery("select e from trainingtask$Employee e where e.center.id = :value")
                        .setParameter("value", center.getId()));
        return dataManager.loadList(loadContext);
    }


}