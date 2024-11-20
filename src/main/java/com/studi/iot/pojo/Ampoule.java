package com.studi.iot.pojo;

import com.studi.iot.pojo.attribute.Couleur;
import com.studi.iot.pojo.attribute.State;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ampoule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private State state;

    private Couleur couleur;

    private Float intensite;

   public Ampoule(State state, Couleur couleur, Float intensite) {
       this.state = state;
       this.couleur = couleur;
       this.intensite = intensite;
   }

   public Ampoule() {

   }

}
