package com.springrenovables.springrenovables_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.springrenovables.springrenovables_app.dao.CentralRepository;
import com.springrenovables.springrenovables_app.dto.MedicionDTO;

@SpringBootApplication
public class SpringrenovablesAppApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringrenovablesAppApplication.class, args);
		var repo = context.getBean(CentralRepository.class);
		//var medicion = MedicionDTO.of(0L, "H1", "H2", (short)5,(short)5,(short)5,(short)5, (short)5);
		repo.save(MedicionDTO.of(1L, "L2", "L1", (short)2, (short)3, (short)5, (short)5, (short)5));
		repo.save(MedicionDTO.of(2L, "L3", "L4", (short)1, (short)5, (short)3, (short)5, (short)3));
		repo.save(MedicionDTO.of(3L, "L3", "L5", (short)6, (short)6, (short)4, (short)7, (short)6));
		repo.save(MedicionDTO.of(4L, "L2", "L5", (short)8, (short)7, (short)5, (short)4, (short)8));

		// System.out.println(medicion);
		System.out.println("-----------------------------");
		// var repo1 = context.getBean(RadiacionRepository.class); 
		// System.out.println(repo1.find("L0","L9", (short)2));
		

		//var repo1 =context.getBean(MedicionesRestRepository.class);
		//repo1.save(Medicion.of(0L, "H1", "H2", (short)5,(short)5,(short)5,(short)5));
		// repo1.delete(6);
		// System.out.println(repo1.findAll());
		System.out.println(repo.findAll());
	}

}
