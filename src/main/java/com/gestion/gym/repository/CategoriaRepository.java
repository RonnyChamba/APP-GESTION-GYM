package com.gestion.gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestion.gym.modelo.Categoria;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Integer>{

	
	@Query("select cate from DetalleCategoria dt "
			+ " inner join Categoria cate on dt.detalleCategoriaPK.idCategoria = cate.id "
			+ " inner join Ejercicio eje on dt.detalleCategoriaPK.idEjercicio = eje.id "
			+ " where eje.nombre = :nombre")
	List<Categoria> findByEjercicio( @Param("nombre") String nombreEjercicio);
}
