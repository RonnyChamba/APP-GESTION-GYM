package com.gestion.gym.service;

import java.util.List;
import java.util.Optional;

import com.gestion.gym.modelo.Categoria;

public interface CategoriaService {

	void save(Categoria categoria);
	
	void update(Categoria categoria);
	
	void delete(Integer id);
	
	List<Categoria> list();
	
	List<Categoria> listByEjercicio(String ejercicio);
	
	Optional<Categoria> findById(Integer id);
	
}
