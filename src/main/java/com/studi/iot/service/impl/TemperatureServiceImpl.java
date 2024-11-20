package com.studi.iot.service.impl;

import com.studi.iot.pojo.Temperature;
import com.studi.iot.repository.TemperatureRepository;
import com.studi.iot.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemperatureServiceImpl implements TemperatureService {

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Override
    public Temperature getTemperature() {
        return null;
    }

    @Override
    public void createTemperature(Temperature temperature) {
        temperatureRepository.save(temperature);

    }
}
