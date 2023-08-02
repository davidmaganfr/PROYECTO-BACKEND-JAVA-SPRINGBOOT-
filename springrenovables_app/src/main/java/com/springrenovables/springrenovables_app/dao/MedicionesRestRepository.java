package com.springrenovables.springrenovables_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import com.springrenovables.springrenovables_app.entities.Medicion;
import reactor.core.publisher.Mono;

@Repository
public class MedicionesRestRepository {

    @Value("${uri.base.mediciones}")
    private String uriBase;
    @Value("${uri.partial.all}")
    private String uriAll;
    @Value("${uri.partial.find}")
    private String uriFind;
    @Value("${uri.partial.create}")
    private String uriCreate;
    @Value("${uri.partial.update}")
    private String uriUpdate;
    @Value("${uri.partial.delete}")
    private String uriDelete;

    private WebClient client = WebClient.builder()
            .baseUrl(uriBase)
            .build();

    public List<Medicion> findAll() {
        return client.get()
                .uri(uriBase + uriAll)
                .retrieve()
                .bodyToFlux(Medicion.class)
                .toStream()
                .toList();
    }

    public Medicion findById(long id) {
        return client.get()
                .uri(uriAll + uriFind + id)
                .retrieve()
                .bodyToMono(Medicion.class)
                .block();
    }

    public void save(Medicion medicion) {
        var med = client.post()
                .uri(uriBase + uriCreate)
                .body(Mono.just(medicion), Medicion.class)
                .exchangeToMono(response -> {
                    System.out.println(response.statusCode());
                    return response.bodyToMono(Medicion.class);
                })
                .block();
        medicion.setId(med.getId());
    }

    public void update(Medicion medicion) {
        client.put()
                .uri(uriBase + uriUpdate + medicion.getId())
                .body(Mono.just(medicion), Medicion.class)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    public void delete(long id) {
        client.delete()
                .uri(uriBase + uriDelete + id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
