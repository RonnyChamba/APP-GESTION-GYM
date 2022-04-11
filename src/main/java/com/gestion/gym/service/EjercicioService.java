package com.gestion.gym.service;

import java.util.List;
import java.util.Optional;
import com.gestion.gym.modelo.Ejercicio;

public interface EjercicioService {

	void save(Ejercicio ejercicio);
	
	void update(Ejercicio ejercicio);
	
	void delete(Integer id);
	
	List<Ejercicio> list();
	
	List<Ejercicio> listByCategoria(String categoria);
	
	Optional<Ejercicio> findById(Integer id);
	
}
