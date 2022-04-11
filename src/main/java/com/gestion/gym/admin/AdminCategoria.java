package com.gestion.gym.admin;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestion.gym.modelo.Categoria;
import com.gestion.gym.service.CategoriaService;

@Component
public class AdminCategoria {

	private static final Logger LOGGER = LogManager.getLogger( AdminCategoria.class);
	
	@Autowired
	private CategoriaService categoriaService;
	
	private Categoria categoria;
	
	public void agregar(String nombre) {
		
		categoria = new Categoria();
		categoria.setNombre(nombre);
		
		categoriaService.save(categoria);
	}
	
	
	public void update(Integer id, String nombre) {
		
		
		Optional<Categoria> option = categoriaService.findById(id);
		
		
		if (option.isPresent()) {
			
			categoria = option.get();
			categoria.setNombre(nombre);
			categoriaService.update(categoria);
		}else LOGGER.info(  "Categoria con id {} no existe", id );
	}
	
	
	public void delete (Integer id) {
		
       Optional<Categoria> option = categoriaService.findById(id);
		
		
		if (option.isPresent()) {
			
			categoriaService.delete(option.get().getId());
			
		}else LOGGER.info(  "Categoria con id {} no existe", id );
		
		
	}
	
	
	public void listar () {
		
	    	
		List<Categoria> categorias = categoriaService.list();
		for (Categoria item: categorias) {
						
			LOGGER.info(item);	
		}	
	}
	
	public void listarPorEjercicio (String ejercicio) {
		
    	
		List<Categoria> categorias = categoriaService.listByEjercicio(ejercicio);
		
		LOGGER.info("Categorias por ejercicio : {}", ejercicio);
		
		for (Categoria item: categorias) {
						
			LOGGER.info(item);	
		}	
	}
	
	
}
