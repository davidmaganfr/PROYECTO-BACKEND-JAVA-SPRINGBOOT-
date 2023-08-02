package com.springrenovables.springrenovables_app.dto;

import com.springrenovables.springrenovables_app.entities.Medicion;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@Data
@NoArgsConstructor
public class MedicionDTO {
    @Delegate()
    private final Medicion medicion = new Medicion();
    private Short radiacion;

    public static MedicionDTO of(long id, String latitud, String longitud, short anny, short temperatura,
            short viento, short precipitacion, Short radiacion) {
        var m = new MedicionDTO();
        m.setId(id);
        m.setLatitud(latitud);
        m.setLongitud(longitud);
        m.setAnny(anny);
        m.setTemperatura(temperatura);
        m.setViento(viento);
        m.setPrecipitacion(precipitacion);
        m.setRadiacion(radiacion);
        return m;
    }
     public static MedicionDTO of(Medicion medicion, Short radiacion) {
        return MedicionDTO.of(medicion.getId(), medicion.getLatitud(), medicion.getLongitud(), medicion.getAnny(),
         medicion.getTemperatura(), medicion.getViento(), medicion.getPrecipitacion(), radiacion);
    }
}
