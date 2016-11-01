package com.haulmont.trainingtask.service;


import com.haulmont.trainingtask.entity.City;

import java.util.List;

public interface CityService {
    String NAME = "trainingtask_CityService";

    /**
     * Get default city
     *
     * @return city with TRUE defaultCity value
     */
    City getDefaultCity();

    /**
     * Set all other cities defaultCity param to FALSE
     *
     * @param city to be new default
     */
    void resetDefaultCity(City city);

    /**
     * Set random default city if user deleted marked as default city
     */
    void setRandomDefaultCity();
}