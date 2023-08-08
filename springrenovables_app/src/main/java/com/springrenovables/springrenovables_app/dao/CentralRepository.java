package com.springrenovables.springrenovables_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springrenovables.springrenovables_app.dto.MedicionDTO;

@Repository
public class CentralRepository {
    private MedicionesRestRepository medicionesRestRepository;
    private RadiacionRepository radiacionRepository;

    @Autowired
    public CentralRepository(MedicionesRestRepository medicionesRestRepository,
            RadiacionRepository radiacionRepository) {
        this.medicionesRestRepository = medicionesRestRepository;
        this.radiacionRepository = radiacionRepository;
    }

    public List<MedicionDTO> findAll() {
        return medicionesRestRepository.findAll()
                .stream()
                .map(m -> MedicionDTO.of(m, radiacionRepository.find(m.getLatitud(), m.getLongitud(), m.getAnny())))
                .toList();
    }

    public MedicionDTO findById(long id) {
        var medicion = medicionesRestRepository.findAll()
                .stream()
                .filter(m -> m.getId() == id)
                .map(m -> MedicionDTO.of(m, radiacionRepository.find(m.getLatitud(), m.getLongitud(), m.getAnny())))
                .findFirst().orElse(null);
        return medicion;
    }
    
    public void save(MedicionDTO dto) {
        medicionesRestRepository.save(dto.getMedicion());
        radiacionRepository.save(dto.getMedicion(), dto.getRadiacion());
    }

    public void update(MedicionDTO dto) {
        medicionesRestRepository.update(dto.getMedicion());
        radiacionRepository.update(dto.getLatitud(), dto.getLongitud(), dto.getAnny(), dto.getRadiacion());
    }

    public void delete(MedicionDTO dto) {
        radiacionRepository.delete(dto.getLatitud(), dto.getLongitud(), dto.getAnny());
        medicionesRestRepository.delete(dto.getMedicion().getId());
    }
}
