package com.studi.iot.configuration.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.studi.iot.pojo.Temperature;
import com.studi.iot.service.TemperatureService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Subscriber {

    private ObjectMapper objectMapper;

    @Autowired
    private TemperatureService temperatureService;

    @RabbitListener(queues="temperature")
    public void receivedTemperature(String message) {
        //On recoit une string
        // {'date':'uneDate','test':'bonjour'}
        Temperature maTemperature = null;

        try {
            maTemperature = objectMapper.readValue(message, Temperature.class);
        }catch (JsonProcessingException e) {
            System.out.println("Le message n'est pas une temperature!");
        }

        if(maTemperature != null){
            temperatureService.createTemperature(maTemperature);
        }
    }



}
