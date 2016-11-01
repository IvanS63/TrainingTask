
package com.haulmont.trainingtask.jmx;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;
import com.haulmont.cuba.core.config.defaults.Default;

/**
 * Configuration interface to set/get email sender name
 */
@Source(type = SourceType.DATABASE)
public interface EmailConfig extends Config {
    @Property("cuba.email.fromAddress")
    @Default("do-not-reply@haulmont.com")
    String getSenderName();

    @Property("cuba.email.fromAddress")
    void setSenderName(String value);
}
