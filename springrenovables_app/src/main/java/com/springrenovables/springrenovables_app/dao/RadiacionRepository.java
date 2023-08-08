package com.springrenovables.springrenovables_app.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springrenovables.springrenovables_app.entities.Medicion;

@Repository
public class RadiacionRepository {

    private static ObjectMapper mapper = new ObjectMapper();
    private File path;
    private List<Map<String, Object>> radiaciones;

    public RadiacionRepository(@Value("${path.radiaciones.json}") String ruta)
            throws StreamReadException, DatabindException, IOException {
        path = new File(ruta);
        radiaciones = mapper.readValue(path, new TypeReference<List<Map<String, Object>>>() {
        });

    }

    private void saveChanges() {
        try {
            mapper.writeValue(path, radiaciones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Object> findRegistro(String latitud, String longitud, short anny) {
        var result = radiaciones.stream()
                .filter(r -> r.get("latitud").equals(latitud))
                .filter(r -> r.get("longitud").equals(longitud))
                .filter(r -> r.get("anny").equals((int) anny))
                .findFirst().orElse(null);
        return result;
    }

    public Short find(String latitud, String longitud, short anny) {
        Map<String, Object> registro = findRegistro(latitud, longitud, anny);
        return registro == null ? null : (short) ((int) registro.get("radiacion"));
    }

    public void update(String latitud, String longitud, short anny, short radiacion) {
        var result = findRegistro(latitud, longitud, anny);
        if (result == null) {
            radiaciones
                    .add(Map.of("latitud", latitud, "longitud", longitud, "anny", anny, "radiacion", (int) radiacion));
        } else {
            result.put("radiacion", (int) radiacion);
        }
        saveChanges();
    }

    public void save(Medicion medicion, short radiacion) {
        radiaciones.add(Map.of("latitud", medicion.getLatitud(),
                "longitud", medicion.getLongitud(),
                "anny", medicion.getAnny(),
                "radiacion", radiacion));
        saveChanges();
    }

    public void delete(String latitud, String longitud, short anny) {
        Map<String, Object> registro = findRegistro(latitud, longitud, anny);
        radiaciones.remove(registro);
        saveChanges();
    }
}
