package com.gestion.gym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.gym.modelo.Categoria;
import com.gestion.gym.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl  implements CategoriaService{

	@Autowired
	private CategoriaRepository  categoriaRepository;
	
	
	@Transactional
	@Override
	public void save(Categoria categoria) {
	
		categoriaRepository.save(categoria);
		
	}

	@Transactional
	@Override
	public void update(Categoria categoria) {
		
		 categoriaRepository.save(categoria);
		
	}

	
	@Transactional
	@Override
	public void delete(Integer id) {
		
		categoriaRepository.deleteById(id);
		
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Categoria> list() {
		
		
		return categoriaRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Categoria> findById(Integer id) {
			
		return  categoriaRepository.findById(id);
	}

	@Override
	public List<Categoria> listByEjercicio(String ejercicio) {
		
		return categoriaRepository.findByEjercicio(ejercicio);
	}

	
	
	
}
