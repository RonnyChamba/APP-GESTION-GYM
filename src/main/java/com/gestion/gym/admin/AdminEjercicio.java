package com.gestion.gym.admin;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gestion.gym.modelo.Ejercicio;
import com.gestion.gym.service.EjercicioService;

@Component
public class AdminEjercicio {

	private static final Logger LOGGER = LogManager.getLogger( AdminEjercicio.class);
	
	@Autowired
	private  EjercicioService ejercicioService;
	
	private Ejercicio ejercicio;
	public AdminEjercicio() {}
	
	
	public void agregar(String nombre) {
		
		ejercicio = new Ejercicio();
		ejercicio.setNombre(nombre);
		
		ejercicioService.save(ejercicio);
	}
	
	
	public void update(Integer id, String nombre) {
		
		
		Optional<Ejercicio> ejercicioOption = ejercicioService.findById(id);
		
		
		if (ejercicioOption.isPresent()) {
			
			ejercicio = ejercicioOption.get();
			ejercicio.setNombre(nombre);
			ejercicioService.update(ejercicio);
		}else LOGGER.info(  "Ejercicio con id {} no existe", id );
	}
	
	
	public void delete (Integer id) {
		
       Optional<Ejercicio> ejercicioOption = ejercicioService.findById(id);
		
		
		if (ejercicioOption.isPresent()) {
			
			ejercicioService.delete(ejercicioOption.get().getId());
			
		}else LOGGER.info(  "Ejercicio con id {} no existe", id );
		
		
	}
	
	
	public void listar () {
		
	    	
		List<Ejercicio> ejercicios = ejercicioService.list();
		for (Ejercicio item: ejercicios) {
						
			LOGGER.info(item);	
		}	
	}
	
	public void listarPorCategoria (String categoria) {
		
    	
		List<Ejercicio> ejercicios = ejercicioService.listByCategoria(categoria);
		
		LOGGER.info("Ejercicios por cateogoria : {}", categoria);
		
		for (Ejercicio item: ejercicios) {
						
			LOGGER.info(item);	
		}	
	}
	
}
