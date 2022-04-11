package com.gestion.gym.admin;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestion.gym.modelo.DetalleCategoria;
import com.gestion.gym.service.DetalleCategoriaService;

@Component
public class AdminDetalleCategoria {

	private static final Logger LOGGER = LogManager.getLogger( AdminDetalleCategoria.class);
	
	@Autowired
	private DetalleCategoriaService detalleService;
	
	private DetalleCategoria detalleCategoria;
	
    
	public void agregar(Integer idCategoria, Integer idEjercicio) {
		
	   detalleCategoria = new DetalleCategoria();
	   
	   detalleCategoria.getDetalleCategoriaPK().setIdCategoria(idCategoria);
	   
	   detalleCategoria.getDetalleCategoriaPK().setIdEjercicio(idEjercicio);
	   
	   detalleService.save(detalleCategoria);
	}
	

	/**
	 * 
	 * @param detalleCategoria
	 * @param idNuevaCategoria
	 */
	public void update(DetalleCategoria detalleCategoria  ,Integer idNuevaCategoria) {	
		
		this.detalleCategoria = detalleCategoria;
		
		detalleService.update(this.detalleCategoria, idNuevaCategoria);
	}
	
	
	public void delete( Integer idCategoria, Integer idEjercicio) {
		   detalleCategoria = new DetalleCategoria();
		   
		   detalleCategoria.getDetalleCategoriaPK().setIdCategoria(idCategoria);
		   
		   detalleCategoria.getDetalleCategoriaPK().setIdEjercicio(idEjercicio);
		   
		   detalleService.delete(detalleCategoria);
		
		
	}
	
	public void list() {
		
		List<DetalleCategoria> detalles =  detalleService.list();
		
		for(DetalleCategoria item : detalles) {
			
			LOGGER.info("{} {}", item.getCategoria(), item.getEjercicio());
			
		}
		
	}
	
	
	
}
