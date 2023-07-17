package com.meteojava.meteojava_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meteojava.meteojava_app.entities.Medicion;

public interface MedicionesRepository extends JpaRepository<Medicion, Long> {
    
}
