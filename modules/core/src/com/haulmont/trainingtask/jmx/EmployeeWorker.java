
package com.haulmont.trainingtask.jmx;

import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.Configuration;
import com.haulmont.cuba.core.global.EmailInfo;
import com.haulmont.cuba.core.global.Scripting;
import com.haulmont.cuba.security.app.Authenticated;
import com.haulmont.trainingtask.entity.Employee;
import com.haulmont.trainingtask.service.EmployeeService;
import groovy.lang.Binding;
import org.springframework.stereotype.Component;

import javax.inject.Inject;


@Component("trainingtask_EmployeeWorkerMBean")
public class EmployeeWorker implements EmployeeWorkerMBean {

    /**
     * Path to forming message text groovy script location
     */
    private static final String GROOVY_SCRIPT_LOCATION =
            "com/haulmont/trainingtask/jmx/script/email.groovy";

    @Inject
    private EmployeeService employeeService;

    @Inject
    private EmailService emailService;

    @Inject
    private Scripting scripting;

    @Inject
    protected Configuration configuration;

    @Override
    @Authenticated
    public void sendGreeting() {
        if (employeeService.getEmployeeWithBirthdays().size() > 0) {
            for (Employee employee : employeeService.getEmployeeWithBirthdays()) {
                EmailInfo emailInfo = new EmailInfo(employee.getEmail(), "Happy Birthday!!!",
                        configuration.getConfig(EmailConfig.class).getSenderName(),
                        formEmailMessage(employee.getFirstName()));
                emailService.sendEmailAsync(emailInfo);

            }
        }
    }

    /**
     * Form message using groovy script
     *
     * @param employeeName employee name to be inserted
     * @return formed text message
     */
    private String formEmailMessage(String employeeName) {
        Binding binding = new Binding();
        binding.setVariable("name", employeeName);
        return scripting.runGroovyScript(GROOVY_SCRIPT_LOCATION, binding);
    }

    /**
     * Set email sender name
     *
     * @param value email address
     */
    @Override
    @Authenticated
    public void setSenderName(String value) {
        configuration.getConfig(EmailConfig.class).setSenderName(value);
    }
}
