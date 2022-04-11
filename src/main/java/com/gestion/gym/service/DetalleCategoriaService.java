package com.gestion.gym.service;

import java.util.List;
import java.util.Optional;
import com.gestion.gym.modelo.DetalleCategoria;
import com.gestion.gym.modelo.DetalleCategoriaPK;

public interface DetalleCategoriaService {

	void save(DetalleCategoria detalleCategoria);
	
	void update(DetalleCategoria detalleCategoria, Integer idNuevaCategoria);
	
	void delete(DetalleCategoria detalleCategoria);
	
	List<DetalleCategoria> list();
	
	Optional<DetalleCategoria> findById(DetalleCategoriaPK detalleCategoriaPK);
	
}
