package com.studi.iot.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Temperature {

    @Id
    private Long id;

    private LocalDateTime dateCollecte;

    private Float temperature;

    public Temperature(LocalDateTime dateCollecte, Float temperature) {
        this.dateCollecte = dateCollecte;
        this.temperature = temperature;
    }

    public Temperature() {
        //Constructeur vide pour Spring
    }
}
