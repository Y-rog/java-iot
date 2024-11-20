package com.studi.iot.repository;

import com.studi.iot.pojo.Temperature;
import org.springframework.data.repository.CrudRepository;

public interface TemperatureRepository extends CrudRepository<Temperature, Long> {

}
