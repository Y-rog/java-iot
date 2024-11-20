package com.studi.iot.repository;

import com.studi.iot.pojo.Ampoule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmpouleRepository extends CrudRepository<Ampoule, Long> {
}
