
package com.haulmont.trainingtask.jmx;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(description = "Sends greeting email to employee")
public interface EmployeeWorkerMBean {
    @ManagedOperation(description = "Sends an email to employee")
    void sendGreeting();

    @ManagedOperation(description = "Set sender name")
    @ManagedOperationParameters({@ManagedOperationParameter(name = "value", description = "Email sender name")})
    void setSenderName(String value);
}
