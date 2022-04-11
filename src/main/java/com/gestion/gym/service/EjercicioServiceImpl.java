package com.gestion.gym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.gym.modelo.DetalleCategoria;
import com.gestion.gym.modelo.Ejercicio;
import com.gestion.gym.repository.EjercicioRepository;

@Service
public class EjercicioServiceImpl implements EjercicioService {

	@Autowired
	private EjercicioRepository ejercicioRepository;
	
	
	@Transactional
	@Override
	public void save(Ejercicio ejercicio) {
		
		ejercicioRepository.save(ejercicio);
	}

	@Transactional
	@Override
	public void update(Ejercicio ejercicio) {
		ejercicioRepository.save(ejercicio);

	}

	@Transactional
	@Override
	public void delete(Integer id) {
	
		ejercicioRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Ejercicio> list(boolean fetch) {
		
		List<Ejercicio> ejercicios = ejercicioRepository.findAll();
		
		if (fetch) {
			return ejercicios;
		}
		
	
		/**
		 * Invocacion de metodos para resoover la Lazy  de las relaciones
		 */
		for (Ejercicio item : ejercicios) {
			
			  List<DetalleCategoria>  detalles  = item.getDetallesCategorias();
			  
			  detalles.size();
			  
			  
			  for(DetalleCategoria itemDetalle: detalles) {
				  
				  itemDetalle.getCategoria().toString();
				  
			  }
			
			
			
			
		}
		
		return  ejercicios;
		
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Ejercicio> findById(Integer id) {
		
		return  ejercicioRepository.findById(id);
	}

	@Override
	public List<Ejercicio> listByCategoria(String categoria) {
		
		return  ejercicioRepository.findByCategoria(categoria);
	}

}
