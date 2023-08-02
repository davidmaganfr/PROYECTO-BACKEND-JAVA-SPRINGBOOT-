package com.meteojava.meteojava_app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "dmfmediciones")
public class Medicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 
    private String latitud;
    private String longitud;
    private short anny;
    private short temperatura;// en grados centigrados
    private short viento; //en metros por segundo
    private short precipitacion; //en milimetros por hora
}
