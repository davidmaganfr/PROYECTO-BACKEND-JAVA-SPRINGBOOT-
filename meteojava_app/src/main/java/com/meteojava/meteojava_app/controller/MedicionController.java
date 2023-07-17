package com.meteojava.meteojava_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meteojava.meteojava_app.dao.MedicionesRepository;
import com.meteojava.meteojava_app.entities.Medicion;

@RestController
public class MedicionController {
    @Autowired
    private MedicionesRepository repo;

    @PostMapping("/create")
    public void create(@RequestBody Medicion medicion){
        
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody Medicion medicion){
        var med = repo.findById(medicion.getMedicion_ID()).get();
        repo.save(med);
    }
}
