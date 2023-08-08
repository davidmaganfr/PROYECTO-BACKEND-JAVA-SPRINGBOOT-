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
    private Long id; 
    private String latitud;
    private String longitud;
    private Short anny;
    private Short temperatura;// en grados centigrados
    private Short viento; //en metros por segundo
    private Short precipitacion; //en milimetros por hora
}
