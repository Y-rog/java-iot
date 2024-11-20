package com.studi.iot.service.impl;

import com.studi.iot.pojo.Ampoule;
import com.studi.iot.repository.AmpouleRepository;
import com.studi.iot.service.AmpouleService;
import org.springframework.beans.factory.annotation.Autowired;

public class AmpouleServiceImpl implements AmpouleService {

    @Autowired
    private AmpouleRepository ampouleRepository;

    @Override
    public void createAmpoule(Ampoule ampoule) {
        this.ampouleRepository.save(ampoule);
    }
}
