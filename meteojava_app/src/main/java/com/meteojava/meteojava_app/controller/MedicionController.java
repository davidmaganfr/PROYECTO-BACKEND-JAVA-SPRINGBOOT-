package com.meteojava.meteojava_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meteojava.meteojava_app.dao.MedicionesRepository;
import com.meteojava.meteojava_app.entities.Medicion;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin()
@RestController
@RequestMapping("/")
public class MedicionController {
    @Autowired
    private MedicionesRepository repo;

    @GetMapping("/all")
    public Flux<Medicion> all(){
        return Flux.fromIterable(repo.findAll());
    }

    @GetMapping("/find/{id:\\d+}")
    public Mono<Medicion> buscar(@PathVariable long id){
        var med = repo.findById(id);
        return Mono.just(med.get());
    }

    @PostMapping("/create")
    public Mono<Medicion> crear(@RequestBody Medicion medicion){
        repo.save(medicion);
        return Mono.just(medicion);
    }

    @PutMapping("/updateBy/{id:\\d+}")
    public void modificar(@RequestBody Medicion medicion, @PathVariable long id){
        medicion.setId(id);
        if(!repo.existsById(id)){
            throw new RuntimeException("Not found");
        }
        repo.save(medicion);
    }

    @DeleteMapping("/delete/{id:\\d+}")
    public void delete(@PathVariable long id){
        repo.deleteById(id);
    }
}
