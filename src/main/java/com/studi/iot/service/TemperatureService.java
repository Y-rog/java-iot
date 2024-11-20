package com.studi.iot.service;

import com.studi.iot.pojo.Temperature;

public interface TemperatureService {

    Temperature getTemperature();

    void createTemperature(Temperature temperature);
}
