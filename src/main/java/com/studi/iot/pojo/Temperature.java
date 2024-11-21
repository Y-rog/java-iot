package com.studi.iot.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Temperature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public boolean equals(Temperature obj) {
        return this.id.equals(obj.getId()) &&
                this.dateCollecte.equals(obj.getDateCollecte()) &&
                this.temperature.equals(obj.getTemperature());
    }
}
