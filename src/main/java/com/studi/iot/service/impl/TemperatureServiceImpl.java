package com.studi.iot.service.impl;

import com.studi.iot.pojo.Temperature;
import com.studi.iot.repository.TemperatureRepository;
import com.studi.iot.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureServiceImpl implements TemperatureService {

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Override
    public Temperature getTemperatureById(Long id) {
        return temperatureRepository.findById(id).orElse(null);
    }

    @Override
    public void createTemperature(Temperature temperature) {
        temperatureRepository.save(temperature);

    }

    @Override
    public List<Temperature> getAllTemperatures() {
        return (List<Temperature>) temperatureRepository.findAll();
    }

    @Override
    public void deleteTemperatureById(Long id){
        temperatureRepository.deleteById(id);
    }

    @Override
    public void updateTemperature(Long id, Temperature temperature) {
        Temperature maTemperature = this.getTemperatureById(id);

        //SI j'ai une Température
        if(maTemperature != null){

            //Je modifie les informations
            maTemperature.setTemperature(temperature.getTemperature());
            maTemperature.setDateCollecte(temperature.getDateCollecte());

            //Je le sauvegarde en base
            temperatureRepository.save(maTemperature);
        }
    }
}
