package com.meteojava.meteojava_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.meteojava.meteojava_app.dao.MedicionesRepository;
import com.meteojava.meteojava_app.entities.Medicion;

@SpringBootApplication
public class MeteojavaAppApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(MeteojavaAppApplication.class, args);
		var repo = context.getBean(MedicionesRepository.class);
		repo.save(Medicion.of(0L, "l1", "l2", (short)1,(short)1,(short)1,(short)1));
		repo.save(Medicion.of(1L, "l3", "l4", (short)2,(short)2,(short)2,(short)2));
		repo.save(Medicion.of(2L, "l6", "l7", (short)5,(short)4,(short)7,(short)2));
		repo.save(Medicion.of(3L, "l0", "l9", (short)2,(short)2,(short)7,(short)8));
	}

}
