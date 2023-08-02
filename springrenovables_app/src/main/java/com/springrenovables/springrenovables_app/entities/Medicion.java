package com.springrenovables.springrenovables_app.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(of = {"id"})
public class Medicion {
    private long id; 
    private String latitud;
    private String longitud;
    private Short anny;
    private Short temperatura;
    private Short viento; 
    private Short precipitacion; 
    
}
