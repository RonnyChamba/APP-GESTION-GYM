package com.gestion.gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestion.gym.modelo.Categoria;
import com.gestion.gym.modelo.Ejercicio;

@Repository
public interface EjercicioRepository extends JpaRepository<Ejercicio, Integer>{
	
	
	/**
	 * Metodo consulta todos los ejercicios pertencientes a una {@link Categoria} especifica
	 * @param nombreCategoria
	 * @return
	 */
	@Query("select eje from DetalleCategoria dt "
			+ " inner join Ejercicio eje on dt.detalleCategoriaPK.idEjercicio = eje.id "
			+ " inner join Categoria cate on dt.detalleCategoriaPK.idCategoria = cate.id  "
			+ " where cate.nombre = :nombre")
	List<Ejercicio> findByCategoria( @Param("nombre") String nombreCategoria);
	
}
