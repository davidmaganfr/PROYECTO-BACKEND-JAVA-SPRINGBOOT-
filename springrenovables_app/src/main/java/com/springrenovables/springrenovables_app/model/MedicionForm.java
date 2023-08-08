package com.springrenovables.springrenovables_app.model;

import com.springrenovables.springrenovables_app.dto.MedicionDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class MedicionForm {
    private long id;
    private String latitud;
    private String longitud;
    private Short anny;
    private Short temperatura;
    private Short viento;
    private Short precipitacion;
    private Short radiacion;

    public MedicionDTO toMedicionDTO() {
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

    public static MedicionForm from(MedicionDTO medicion) {
        if (medicion == null) {
            return null;
        }
        var m = new MedicionForm();
        m.setId(medicion.getId());
        m.setLatitud(medicion.getLatitud());
        m.setLongitud(medicion.getLongitud());
        m.setAnny(medicion.getAnny());
        m.setTemperatura(medicion.getTemperatura());
        m.setViento(medicion.getViento());
        m.setPrecipitacion(medicion.getPrecipitacion());
        m.setRadiacion(medicion.getRadiacion());

        return m;
    }
}
