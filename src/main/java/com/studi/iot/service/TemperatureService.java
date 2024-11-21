package com.studi.iot.service;

import com.studi.iot.pojo.Temperature;

import java.util.List;

public interface TemperatureService {

    Temperature getTemperatureById(Long id);

    void createTemperature(Temperature temperature);

    List<Temperature> getAllTemperatures();

    void deleteTemperatureById(Long id);

    void updateTemperature(Long id, Temperature temperature);

}
