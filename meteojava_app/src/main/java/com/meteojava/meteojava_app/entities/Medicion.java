package com.meteojava.meteojava_app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"medicion_ID"})
@Entity
@Table(name = "DMFMediciones")
public class Medicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicion_ID; 
    private String latitud;
    private String longitud;
    private short año;
    private short temperatura;// en grados centigrados
    private short viento; //en metros por segundo
    private short precipitacion; //en milimetros por hora
}
