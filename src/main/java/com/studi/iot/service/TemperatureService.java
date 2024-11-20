package com.studi.iot.service;

import com.studi.iot.pojo.Temperature;

import java.util.List;

public interface TemperatureService {

    Temperature getTemperature();

    void createTemperature(Temperature temperature);

    List<Temperature> getAllTemperatures();
}
