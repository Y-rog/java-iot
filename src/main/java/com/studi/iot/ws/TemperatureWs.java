package com.studi.iot.ws;

import com.studi.iot.pojo.Temperature;
import com.studi.iot.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/temperature")
public class TemperatureWs {

    @Autowired
    private TemperatureService temperatureService;

    //Obtention de toutes les températures
    @GetMapping
    public List<Temperature> getALlTemperatures(){
        //localhost:3000/toto => toto est un PathVariable
        //localhost:3000?toto => toto est un RequestParam (r    re)
        return temperatureService.getAllTemperatures();
    }

    //Obtention d'une température
    @GetMapping("/{id}")
    public Temperature getTemperatureById(@PathVariable Long id){
        return temperatureService.getTemperatureById(id);
    }

    @PutMapping("/{id}")
    public void updateTemperature(@PathVariable Long id, @RequestBody Temperature temperature){
        temperatureService.updateTemperature(id, temperature);
    }


    @PostMapping
    public void createTemperature(@RequestBody Temperature temperature){
        temperatureService.createTemperature(temperature);
    }

    @DeleteMapping("/{id}")
    public void deleteTemperatureById(@PathVariable Long id){
        temperatureService.deleteTemperatureById(id);
    }


}
