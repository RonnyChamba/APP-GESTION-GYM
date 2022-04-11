package com.gestion.gym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.gym.modelo.Categoria;
import com.gestion.gym.modelo.DetalleCategoria;
import com.gestion.gym.modelo.DetalleCategoriaPK;
import com.gestion.gym.repository.DetalleCategoriaRepository;

@Service
public class DetalleCategoriaServiceImpl implements DetalleCategoriaService {

	
	@Autowired
	private DetalleCategoriaRepository detalleRepository;
	
	
	@Transactional
	@Override
	public void save(DetalleCategoria detalleCategoria) {
		detalleRepository.save(detalleCategoria);
	}

	@Transactional
	@Override
	public void update(DetalleCategoria detalleCategoria, Integer idNuevaCategoria) {
		detalleRepository.updateDetalleCategoria( idNuevaCategoria, detalleCategoria.getDetalleCategoriaPK());
		
	}

	@Transactional
	@Override
	public void delete(DetalleCategoria detalleCategoria) {
		
		Optional<DetalleCategoria> detalle = findById(detalleCategoria.getDetalleCategoriaPK());
		
		if (detalle.isPresent()) {
			detalleRepository.deleteByCustomId(detalle.get().getDetalleCategoriaPK());
		}
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<DetalleCategoria> list() {
		
		return  detalleRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<DetalleCategoria> findById(DetalleCategoriaPK detalleCategoriaPK) {
	
		return  detalleRepository.findById(detalleCategoriaPK);
	}


	
	
}
